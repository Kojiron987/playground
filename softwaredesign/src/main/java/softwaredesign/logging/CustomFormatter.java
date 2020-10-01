package softwaredesign.logging;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder(100);
        sb.append(enclose(toDateTimeString(record.getMillis())));
        sb.append(" ");
        sb.append(enclose(convertLevel(record.getLevel())));
        sb.append(" ");
        sb.append(record.getMessage());
        sb.append(System.lineSeparator());

        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            record.getThrown().printStackTrace(pw);
            sb.append(sw.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    @SuppressWarnings("serial")
    private static Map<Level, String> LEVEL_TO_MESSAGE = Collections.unmodifiableMap(new HashMap<>() {{
        put(Level.SEVERE, "Error");
        put(Level.WARNING, "Warn");
        put(Level.INFO, "Info");
        put(Level.CONFIG, "Debug");
        put(Level.FINE, "Debug");
        put(Level.FINER, "Debug");
        put(Level.FINEST, "Debug");
    }});

    private static String enclose(String target) {
        return "[" + target + "]";
    }

    private static String toDateTimeString(long mills) {
        Instant instant = Instant.ofEpochMilli(mills);
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        return formatter.format(ldt);
    }

    private static String convertLevel(Level level) {
        String result = LEVEL_TO_MESSAGE.get(level);

        if (result != null) {
            return result;
        } else {
            return level.toString();
        }
    }
}
