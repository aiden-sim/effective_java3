package chapter6.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * 열거 타입용 fromString 메서드 구현
 */
public enum Operation4 {
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
    private final String symbol;

    Operation4(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }

    private static final Map<String, Operation4> stringToEnum =
            Stream.of(values()).collect(
                    toMap(Object::toString, e -> e));

    // 지정한 symbol에 해당하는 Operation이 존재하면 반환
    // Optional을 사용한 이유는 Client단에서 null이 나올수 있다는 것을 인지시키기 위해
    public static Optional<Operation4> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        Optional<Operation4> result = Operation4.fromString("+");
    }
}
