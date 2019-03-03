package chapter7.item43.etc.bound;

import java.util.function.IntBinaryOperator;

public class Calculator {
    public int mul(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();

        // Using a lambda expression
        IntBinaryOperator operator1 = (a, b) -> cal.mul(a, b);
        System.out.println(operator1.applyAsInt(5, 6));

        // Using a method reference
        IntBinaryOperator operator2 = cal::mul;
        System.out.println(operator2.applyAsInt(5, 6));

    }
}
