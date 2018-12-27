package chapter5.item30;

import java.util.HashSet;
import java.util.Set;

public class Sample {
    /**
     * 제네릭 미사용
     */
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1); //warning
        result.addAll(s2); //warning
        return result;
    }

    /**
     * 제네릭 메서드
     * 타입 매개변수 목록은 메서드의 제한자와 반환 타입 사이에 온다.
     */
    public static <E> Set<E> union2(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /**
     * 한정적 와일드카드
     */
    public static <E> Set<E> union3(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }


    public static void main(String[] args) {
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
        Set<String> aflCio = union2(guys, stooges);
        System.out.println(aflCio);

        Set<Integer> integers = Set.of(1, 3, 5);
        Set<Double> doubles = Set.of(2.0, 4.0, 6.0);
        Set<Number> numbers = union3(integers, doubles);
    }
}
