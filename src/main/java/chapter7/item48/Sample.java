package chapter7.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class Sample {
	public static void main(String[] args) {

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
