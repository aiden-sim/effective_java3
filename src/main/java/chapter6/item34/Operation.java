package chapter6.item34;

/**
 * 값에 다라 분기하는 열거 타입 (별로 좋지 않다.)
 */
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;

        }
        throw new AssertionError("알 수 없는 연산: " + this);
    }

    public static void main(String[] args) {
        System.out.println(Operation.DIVIDE.apply(3, 4));
    }
}
