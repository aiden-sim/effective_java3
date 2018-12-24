package chapter5.item26;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sample {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        //String s = strings.get(0); // ClassCastException
        //System.out.println(s);


        List<?> list = new ArrayList<>();
        // list.add("verboten");

        // wildcard instanceOf
        instanceOf(strings);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    // 예외
    private static void instanceOf(List<String> list) {
        if (list instanceof List<?>) {
            System.out.println("와일드카드 적용");
        }

        if (list instanceof List) {
            System.out.println("와일드카드 적용");
        }

        // 컴파일 에러
/*        if(list instanceof List<String>) {

        }*/
    }
}
