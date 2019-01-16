package chapter8.item55;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.*;

public class Sample {

	// 컬렉션에서 최대값을 구한다(컬렉션이 비었으면 예외를 던진다).
	public static <E extends Comparable<E>> E max(Collection<E> c) {
		if (c.isEmpty()) {
			throw new IllegalArgumentException("빈 컬렉션");
		}

		E result = null;
		for (E e : c) {
			if (result == null || e.compareTo(result) > 0) {
				result = Objects.requireNonNull(e);
			}
		}
		return result;
	}

	// Optional 형태로 변경
	public static <E extends Comparable<E>> Optional<E> max2(Collection<E> c) {
		if (c.isEmpty()) {
			return Optional.empty();
		}

		E result = null;
		for (E e : c) {
			if (result == null || e.compareTo(result) > 0) {
				result = Objects.requireNonNull(e);
			}
		}
		return Optional.of(result);
	}

	// 컬렉션에서 최댃값을 구해 Optional<E>로 반환 - 스트림 버전
	public static <E extends Comparable<E>> Optional<E> max3(Collection<E> c) {
		return c.stream().max(Comparator.naturalOrder());
	}

	public static void main(String[] args) throws Exception {
		List<String> words = List.of("test", "test2");

		// 기본값을 정해둘 수 있다.
		String lastWordInLexicon = max3(words).orElse("단어 없음...");

		// 원하는 예외를 던질 수 있다.
		String myToy = max3(words).orElseThrow(Exception::new);

		// 항상 값이 채워져 있다고 가정
		String lastNobleGas = max3(words).get();

		// orElseGet
		String object = max3(words).orElseGet(String::new);

	}

}
