package chapter5.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Sample {
    public static void main(String[] args) {
        List<String> list = List.of("test", "test2", "test3");
        // dangerous(list); // ClassCastException
        // String[] attributes = pickTwo("좋은", "빠른", "저렴한"); // ClassCastException

        List<String> attributes2 = pickTwo2("좋은", "빠른", "저렴한");
    }

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;               // 힙 오염 발생... List<String>에 List<Integer>를 넣었음
        String s = stringLists[0].get(0);   // ClassCastException
    }

    // Object 반환한다. T = Object로 변환
    static <T> T[] pickTwo(T a, T b, T c) {
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // 도달할 수 없음
    }

    // List 형태로 변경
    static <T> List<T> pickTwo2(T a, T b, T c) {
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

    // 제네릭 varargs 매개변수를 List로 대체 (타입에 안전)
    static <T> List<T> flatten2(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

}
