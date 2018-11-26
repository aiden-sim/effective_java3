package chapter2.item6;

import java.util.regex.Pattern;

/**
 * Created by simjunbo on 2018-11-18.
 * https://regexper.com/#%5E%28%3F%3D.%29M*%28C%5BMD%5D%7CD%3FC%7B0%2C3%7D%29%22%0A%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%2B%20%22%28X%5BCL%5D%7CL%3FX%7B0%2C3%7D%29%28I%5BXV%5D%7CV%3FI%7B0%2C3%7D%29%24%22
 */
public class RomanNumerals {
    static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {
        int numSets = 10;
        int numReps = 10;
        boolean b = false;

        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                // 성능 차이를 확인하려면 xxxSlow 메서드를 xxxFast 메서드로 바꿔 실행해보자.
                b ^= isRomanNumeralFast("MCMLXXVI");
                //b = isRomanNumeralFast("MDCCLXXIX");
            }
            long end = System.nanoTime();
            System.out.println(((end - start) / (1000. * numReps)) + " μs.");
        }

        // VM이 최적화하지 못하게 막는 코드
        if (!b)
            System.out.println();
    }
}