package chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 대칭성 테스트
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // 대칭성 위배
    @Override
    public boolean equals(Object o) {
/*        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);

        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);

        return false;*/

        // 다음과 같이 변경해야 된다.
        return o instanceof CaseInsensitiveString && (((CaseInsensitiveString) o).s.equalsIgnoreCase(s));
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        if (cis.equals(s)) {
            System.out.println("cis.equals(s) 동일");
        }

        // 대칭성 위배 (type 자체가 안맞는다)
        if (s.equals(cis)) {
            System.out.println("s.equals(cis) 동일");
        }

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        // 대칭성 위배 (type 자체가 안맞는다)
        if (list.contains(s)) {
            System.out.println("list.equals(s) 동일");
        }

    }
}
