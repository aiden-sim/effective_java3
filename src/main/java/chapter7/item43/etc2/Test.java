package chapter7.item43.etc2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * https://goodcodes.tistory.com/entry/Java-8-Feature-Lambda-Expression-Method-Reference
 */
public class Test {
    public static void main(String args[]) {
        /**
         * Static Method References
         * TypeName::staticMethod
         */
        // Static Method References - Lambda Expression
        Function<Integer, String> lambda1 = x -> Integer.toBinaryString(x);
        System.out.println(lambda1.apply(256));
        // Static Method References
        Function<Integer, String> staticReference = Integer::toBinaryString;
        System.out.println(staticReference.apply(256));

        /**
         * Instance Method References
         * objectRef::instanceMethod
         * ClassName::instanceMethod
         */
        // Bound Receiver
        Supplier<Integer> supplier = () -> "Ellen".length();
        System.out.println(supplier.get());
        Supplier<Integer> imr = "Ellen"::length;
        System.out.println(imr.get());

        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Hello");
        Consumer<String> imr2 = System.out::println;
        imr2.accept("Hello");

        // Unbound Receiver
        Function<Person, String> getName = p -> p.getFirstName();
        Function<Person, String> getNameReference = Person::getFirstName;


        /**
         * Constructor References
         * TypeName.super::instanceMethod
         */
        // Lambda
        Supplier<String> func1 = () -> new String();
        Function<String, String> func2 = str -> new String(str);
        // References
        Supplier<String> ref1 = String::new;
        Function<String, String> ref2 = String::new;
    }


}
