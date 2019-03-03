package chapter7.item43.etc.bound;

import java.util.function.Function;

public class BoundType {
    // instance method
    public int cubic(int a) {
        return a * a * a;
    }

    public static void main(String[] args) {
        BoundType cal = new BoundType();
        // Using a lambda expression
        Function<Integer, Integer> operator3 = (a) -> cal.cubic(a);
        System.out.println(operator3.apply(6));

        // Using a method reference (bound type)
        Function<Integer, Integer> operator4 = cal::cubic;
        System.out.println(operator4.apply(6));

    }
}
