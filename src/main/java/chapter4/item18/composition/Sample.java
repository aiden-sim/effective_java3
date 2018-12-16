package chapter4.item18.composition;

import java.util.HashSet;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>(new HashSet<>());
        s.addAll(List.of("틱", "탁탁", "펑"));

        System.out.println(s.getAddCount());
    }
}
