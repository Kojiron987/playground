package play.anoenum;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toMap;

public enum BasicOperation implements Operation{
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public static Optional<BasicOperation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    private final String symbol;

    private BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    private static final Map<String, BasicOperation> stringToEnum = Stream.of(values())
            .collect(toMap(Object::toString, e -> e));
}
