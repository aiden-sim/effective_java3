package chapter7.item43.etc.staticmethod;

import java.util.function.IntBinaryOperator;

public class Calculator {
    // static method and owned bye the class
    public static int mul(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        // Using a lambda expression
        IntBinaryOperator operator1 = (a, b) -> Calculator.mul(a, b);
        System.out.println(operator1.applyAsInt(5, 6));

        // Using a method reference
        IntBinaryOperator operator2 = Calculator::mul;
        System.out.println(operator2.applyAsInt(5, 6));

    }
}
