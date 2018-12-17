package chapter4.item19;

import java.time.Instant;

public final class Sub extends Super {
	private final Instant instant;

	Sub() {
		instant = Instant.now();
	}

	// 상위 클래스 생성자에서 호출되기 때문에 처음에는 초기화가 되지 않는다.
	@Override public void overrideMe() {
		System.out.println(instant);
	}

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.overrideMe();
	}
}
