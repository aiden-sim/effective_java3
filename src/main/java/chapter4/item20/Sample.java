package chapter4.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * 메소드 방식
 */
public class Sample {

	/**
	 * 골격 구현을 사용해 완성한 구체 클래스
	 */
	static List<Integer> intArrayAsList(int[] a) {
		Objects.requireNonNull(a);

		return new AbstractList<>() {
			@Override public Integer get(int i) {
				return a[i];
			}

			@Override public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val;
				return oldVal;
			}

			@Override public int size() {
				return a.length;
			}
		};
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		List<Integer> result = intArrayAsList(a);
		Integer get = result.get(0);
		System.out.println(get);
	}
}
