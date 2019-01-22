package chapter9.item57;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Sample {
    public static void main(String[] args) {
        Class<? extends Set<String>> cl = null;
        try {
            cl = (Class<? extends Set<String>>)
                    Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            System.out.println("클래스를 찾을 없습니다.");
        }

        List<String> list = List.of("test", "tset2", "test3");
        List<String> list2 = List.of("test", "tset2", "test3");

        Iterator<String> i = list.iterator();
        while (i.hasNext()) {

        }

        Iterator<String> i2 = list2.iterator();
        while(i.hasNext()) { // 버그 i를 사용했다.

        }
    }
}
