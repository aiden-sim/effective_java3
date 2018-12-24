package chapter5.item30;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * 재귀적 타입 한정 사용
 */
public class Sample3 {
    // 모든 타입 E는 자신과 비교할 수 있다.
    public static <E extends Comparable<E>> E max(Collection<E> c) throws IllegalAccessException {
        if (c.isEmpty()) {
            throw new IllegalAccessException("컬렉션이 비어 있습니다.");
        }

        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IllegalAccessException {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        System.out.println(max(list));

        List<String> list2 = List.of("가", "나", "다", "라");
        System.out.println(max(list2));
    }
}