package chapter5.item31;

import java.util.List;

public class Sample {
    public static <E> void swap(List<E> list, int i, int j) {

    }

    public static void swap2(List<?> list, int i, int j) {
        //list.set(i, list.set(j, list.get(i))); // ?에는 nul 외에 어떤 값도 넣을 수 없다.
    }

    public static void swap3(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // 도우미 메서드
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {

    }
}
