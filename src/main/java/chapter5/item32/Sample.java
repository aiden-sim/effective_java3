package chapter5.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sample {
    public static void main(String[] args) {
        List<String> attributes = pickTwo("좋은", "빠른", "저렴한"); // ClassCastException
    }

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;               // 힙 오염 발생... List<String>에 List<Integer>를 넣었음
        String s = stringLists[0].get(0);   // ClassCastException
    }

    static <T> List<T> pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return List.of(a, b);
            case 1:
                return List.of(a, c);
            case 2:
                return List.of(b, c);
        }
        throw new AssertionError(); // 도달할 수 없음
    }


    // 안전하지 않다. 배열을 넘긴다.
    static <T> T[] toArray(T... args) {
        return args;
    }

    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

    // 제네릭 varargs 매개변수를 List로 대체
    static <T> List<T> flatten2(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

}
