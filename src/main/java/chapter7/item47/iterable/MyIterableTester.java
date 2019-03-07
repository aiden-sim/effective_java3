package chapter7.item47.iterable;

import java.util.Arrays;
import java.util.List;

public class MyIterableTester {

    public static void main(String[] args) {

        // 1) Iterable
        Integer[] ints = {1, 2, 3, 4, 5};
        MyIterable<Integer> myList = new MyIterable<>(ints);
        // Iterable 구현했으면 foreach 사용할 수 있다.
        for (Integer i : myList) {
            System.out.print(i);
        }

        System.out.println("");

        // 2) List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Iterable의 forEach 가져다 쓴다.
        numbers.forEach(System.out::print);

        System.out.println("");

        // 3) Stream
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        // Iterable의 forEach 가져다 쓴다.
        numbers2.stream().forEach(System.out::print);
    }
}
