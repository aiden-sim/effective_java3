package chapter7.item46;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Sample {
    public static void main(String[] args) {
        // 빈도표에서 가장 흔한 단어 10개를 뽑아내는 파이프라인
        Map<String, Long> freq = Map.of("simjunbo", 33L, "aiden", 33L);
        List<String> topTen = freq.keySet().stream()
                .sorted(Comparator.comparing(freq::get).reversed())
                .limit(10)
                .collect(Collectors.toList());

        // toMap
        // toMap 인자2개
        Map<String, String> map = Arrays.asList("a", "b", "c")
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(), str -> str));

        // 충돌나면 마지막 값을 취한다.
        // toMap 인자3개
        Map<String, String> map2 = Arrays.asList("a", "a", "b", "c")
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(), str -> str, (oldVal, newVal) -> newVal));

        // toMap 인자4개
        LinkedHashMap<String, String> map3 = Arrays.asList("a", "a", "b", "c")
                .stream()
                .collect(Collectors.toMap(Function.identity(), str -> str, (oldVal, newVal) -> newVal, LinkedHashMap::new));

        // groupingBy
        // 인자1개
        Map<String, List<String>> group = Arrays.asList("a", "a", "b", "c")
                .stream()
                .collect(Collectors.groupingBy(Function.identity()));

        // 인자2개
        Map<String, Set<Object>> group2 = Arrays.asList("a", "a", "b", "c")
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), toSet()));

        // 인자3개
        Map<String, Set<Object>> group3 = Arrays.asList("a", "a", "b", "c")
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, toSet()));



    }
}
