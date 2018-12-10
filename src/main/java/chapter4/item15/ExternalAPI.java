package chapter4.item15;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExternalAPI {
    // 보안 허점이 있다.
    // public static final Thing[] VALUES = {new Thing()};

    // 해결책
    // 1) 불변 리스트 추가
    //private static final Thing[] PRIVATE_VALUES = {new Thing()};
    //public static final List<Thing> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    // 2) 배열을 private으로 만들고 그 복사본을 반환하는 public메서드 추가 (방어적 복사)
    private static final Thing[] PRIVATE_VALUES = {new Thing()};
    public static final Thing[] values() {
        return PRIVATE_VALUES.clone();
    }


}
