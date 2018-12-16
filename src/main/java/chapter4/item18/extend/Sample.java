package chapter4.item18.extend;

import java.util.List;

public class Sample {
    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(List.of("틱", "탁탁", "펑"));

        // 3개를 생각했지만 6개가 되었다.
        // addAll 내부적으로 add를 호출하기 때문이다.
        System.out.println(s.getAddCount());
    }
}
