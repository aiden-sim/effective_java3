package chapter8.item57;

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
    }
}
