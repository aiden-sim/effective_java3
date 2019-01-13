package chapter8.item52;

import java.math.BigInteger;
import java.util.*;

public class CollectionClassifier {
    // 오버로딩은 컴파일 시점에 타입이 확정되기 때문에 Collection<?> c 만 호출된다.
    /*
    public static String classify(Set<?> s) {
        return "집합";
    }

    public static String classify(List<?> lst) {
        return "리스트";
    }

    public static String classify(Collection<?> c) {
        return "그 외";
    }
    */

    // 이를 해결하기 위해 instanceof를 사용한다.
    public static String classify(Collection<?> c) {
        return c instanceof Set ? "집합" :
                c instanceof List ? "리스트" : "그 외";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
        }
    }
}
