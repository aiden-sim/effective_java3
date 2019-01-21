package chapter8.item63;

public class Test {
	public static void main(String[] args) {
		long first = System.nanoTime();
		case1();
		System.out.println(System.nanoTime() - first);

		first = System.nanoTime();
		case2();
		System.out.println(System.nanoTime() - first);

		first = System.nanoTime();
		case3();
		System.out.println(System.nanoTime() - first);
	}

	// String + 사용
	private static void case1() {
		String s = "abc";
		for (int i = 0; i < 50000; i++) {
			s += "a";
		}
	}

	// String + builder로 변환 버전 (객체를 계속 생성한다.)
	private static void case2() {
		String s = "abc";
		for (int i = 0; i < 50000; i++) {
			s = new StringBuilder(String.valueOf(s)).append("a").toString();
		}
	}

	// 정상적인 builder 버전
	private static void case3() {
		StringBuilder s = new StringBuilder("abc");
		for (int i = 0; i < 50000; i++) {
			s.append("a");
		}
	}
}
