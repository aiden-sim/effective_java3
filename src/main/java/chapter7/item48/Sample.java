package chapter7.item48;

import java.math.BigInteger;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public class Sample {
    public static void main(String[] args) {

        // 단일 스레드
        int r = ThreadLocalRandom.current().nextInt(4, 77);
        System.out.println(r);

        // 병렬 스레드
        SplittableRandom sr = new SplittableRandom();
        int r2 = sr.nextInt(4, 77);
        System.out.println(r2);
    }

    // 소수 계산 스트림 파이프라인 - 병렬화에 적합하다.
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
