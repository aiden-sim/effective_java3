package chapter3.item10;

import java.math.BigDecimal;

/**
 * 부동소수
 */
public class FloatingPoint {
    public static void main(String[] args) {
        double d1 = 2.4;
        double d2 = 0.8;
        System.out.println(d1 / d2);

        BigDecimal d3 = new BigDecimal("2.4");
        BigDecimal d4 = new BigDecimal("0.8");
        System.out.println(d3.divide(d4));

        // 주의
        BigDecimal d5 = new BigDecimal(2.4);
        BigDecimal d6 = new BigDecimal(0.8);
        //System.out.println(d5.divide(d6));      // java.lang.ArithmeticException

        System.out.println(0.0 / 0.0);        // NaN
        System.out.println(Math.sqrt(-2.0));  // NaN : 음수의 제곱근을 구할 때
        System.out.println(Double.NaN);       // NaN : 상수

        System.out.println(2.0 / 0.0);                // Infinity
        System.out.println(Double.MAX_VALUE * 2);     // Infinity
        System.out.println(Double.POSITIVE_INFINITY); // Infinity  : 상수
        System.out.println(Double.NEGATIVE_INFINITY); // -Infinity : 상수

        System.out.println((-0.0) + (-0.0));

        System.out.println(Double.MIN_VALUE / Double.MIN_VALUE); // 1.0
        System.out.println(Double.MIN_VALUE / 0.0);              // Infinity
        System.out.println(0.0 / Double.MIN_VALUE);
    }
}
