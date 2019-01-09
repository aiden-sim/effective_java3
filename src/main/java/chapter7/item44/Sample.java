package chapter7.item44;

import java.util.*;
import java.util.function.*;

/**
 * 참고
 * http://www.java2s.com/Tutorials/Java/java.util.function/UnaryOperator/index.htm
 * https://www.concretepage.com/java/jdk-8/java-8-unaryoperator-binaryoperator-example
 */
public class Sample {
    public static void main(String[] args) {
        // UnaryOperator
        // T apply(T t)
        UnaryOperator<String> operator = u -> u.toUpperCase(); // return
        System.out.println(operator.apply("java2s.com"));

        // BinaryOperator
        // T apply(T t1, T t2)
        BinaryOperator<Integer> adder = (n1, n2) -> n1 + n2; // return
        System.out.println(adder.apply(3, 4));

        // Predicate
        // boolean test(T t)
        Predicate<String> p = s -> s.length() > 5; // return
        System.out.println(p.test("java2s.com "));

        // Function
        // R apply(T t)
        Function<Integer, String> converter = f -> Integer.toString(f); // return
        System.out.println(converter.apply(3));
        System.out.println(converter.apply(30));

        // Supplier
        // T get()
        Supplier<String> i = () -> "java2s.com"; // return
        System.out.println(i.get());

        // Consumer
        // void accept(T t)
        Consumer<String> consumer = c -> System.out.println(c.toLowerCase());
        consumer.accept("Java2s.com");
    }
}
