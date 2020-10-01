package softwaredesign.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {
    private static final Logger logger = Logger.getLogger("test");

    private static final Logging instance = new Logging();


    private Logging() {
        try {
            FileHandler handler = new FileHandler("log.log", true);
            handler.setFormatter(new CustomFormatter());
            logger.addHandler(handler);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void info(String message) {
        logger.info(message);
    }
    public void info(String message, Throwable t) {
        logger.log(Level.INFO, message, t);
    }

    public void debug(String message) {
        logger.fine(message);
    }
    public void debug(String message, Throwable t) {
        logger.log(Level.FINE, message, t);
    }

    public void error(String message) {
        logger.severe(message);
    }
    public void error(String message, Throwable t) {
        logger.log(Level.SEVERE, message, t);
    }

    public void warn(String message) {
        logger.warning(message);
    }
    public void warn(String message, Throwable t) {
        logger.log(Level.WARNING, message, t);
    }
}
