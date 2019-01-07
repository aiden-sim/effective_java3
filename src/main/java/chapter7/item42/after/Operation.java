package chapter7.item42.after;

import java.util.function.DoubleBinaryOperator;

/**
 * 함수 객체(람다)를 인스턴스 필드에 저장해 상수별 동작을 구현한 열거 타입
 */
public enum Operation {
    PLUS("+", (x, y) -> x + y) {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-", (x, y) -> x - y) {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*", (x, y) -> x * y) {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/", (x, y) -> x / y) {
        public double apply(double x, double y) {
            return x / y;
        }
    };
    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }
}
