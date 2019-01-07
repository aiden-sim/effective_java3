package chapter7.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sample {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("틱", "택", "톡");

        // 익명클래스로 처리한 낡은 기법
        Collections.sort(words,
                new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        return Integer.compare(s1.length(), s2.length());
                    }
                });

        // 람다식을 함수 객체로 사용 (익명 클래스 대체)
        Comparator<String> comparator = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
        Collections.sort(words, comparator);

        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // 람다 코드 좀더 간결하게
        Collections.sort(words, Comparator.comparingInt(String::length));

        // List의 sort
        words.sort(Comparator.comparingInt(String::length));
    }
}
