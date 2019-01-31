package chapter5.etc;

import java.util.Set;
import java.util.HashSet;

/**
 * 위험한 케이스
 * T extends E 로 하면 아무 타입이나 대입이 되버린다.
 * 결국 Cast 오류 발생할 수 있음
 */
public class Test {
	public static void main(String[] args) {
		Set<Integer> s1 = new HashSet<>();
		s1.add(1);
		Set<String> s2 = new HashSet<>();
		s2.add("test");

		Set<String> s3 = union(s1, s2);
	}

	// E = Integer, T = String
	public static <E, T extends E> Set<T> union(Set<? extends E> s1, Set<? extends T> s2) {
		// Set<T> result = new HashSet<T>(s1); type을 정확하게 잡아주면 컴파일 단에서 warning은 나옴
		Set<T> result = new HashSet(s1);
		result.addAll(s2);
		return result;
	}
}
