package chapter7.item43.etc.unbound;

import java.util.ArrayList;
import java.util.List;

// ternary
@FunctionalInterface
interface Custom<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class UnBoundType2 {

    // instance method
    public int cubic(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        UnBoundType2 cal = new UnBoundType2();

        // Using a lambda expression
        Custom<UnBoundType2, Integer, Integer, Integer> operator = (a, b, c) -> a.cubic(b, c);
        System.out.println(operator.apply(cal, 6, 5));

        List<Child> list = new ArrayList<>();
        list.add(new Child("dog", 1));
        list.add(new Child("cat", 1));


        Custom<UnBoundType2, Integer, Integer, Integer> custom = (a, b, c) -> a.cubic(b, c);
        Custom<UnBoundType2, Integer, Integer, Integer> custom2 = UnBoundType2::cubic;

/*
        String number = list.stream()
                .map(custom)
                .findAny().get();
        System.out.println(number);
*/
    }


    private static class Child {
        private String name;

        private int age;

        public Child(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getNumber(int number) {
            return number;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}