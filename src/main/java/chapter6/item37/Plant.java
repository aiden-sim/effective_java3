package chapter6.item37;

import java.util.*;
import java.util.stream.Collectors;

public class Plant {
    enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}

    final String name;
    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }


    public static void main(String[] args) {
        Plant[] garden = {
                new Plant("바질", LifeCycle.ANNUAL),
                new Plant("캐러웨이", LifeCycle.BIENNIAL),
                new Plant("딜", LifeCycle.ANNUAL),
                new Plant("라벤더", LifeCycle.PERENNIAL),
                new Plant("파슬리", LifeCycle.BIENNIAL),
                new Plant("로즈마리", LifeCycle.PERENNIAL)
        };

        // 코드 37-1 ordinal()을 배열 인덱스로 사용 - 따라 하지 말 것!
        Set<Plant>[] plantsByLifeCycleArr =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            plantsByLifeCycleArr[i] = new HashSet<>();
        }

        for (Plant p : garden) {
            plantsByLifeCycleArr[p.lifeCycle.ordinal()].add(p);
        }

        // 결과 출력
        for (int i = 0; i < plantsByLifeCycleArr.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycleArr[i]);
        }

        // EnumMap을 사용해 데이터와 열거 타입을 매핑한다.
        Map<LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for (Plant p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }
        System.out.println(plantsByLifeCycle);


        // 스트림을 사용한 코드 (EnumMap을 사용하지 않는다.)
        System.out.println(Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle)));

        Map<LifeCycle, List<Plant>> result = Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle));


        // 스트림을 사용한 코드 (EnumMap을 사용한다.)
        System.out.println(Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), Collectors.toSet())));

        EnumMap<LifeCycle, Set<Plant>> result2 = Arrays.stream(garden)
                .collect(Collectors.groupingBy(p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class), Collectors.toSet()));

    }
}
