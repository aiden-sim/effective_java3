package chapter8.item49;

import org.apache.commons.lang3.ArrayUtils;

public class Sample {
	public static void main(String[] args) {
		// 자바의 null 검사 기능 사용하기
		//String strategy = null;
		//strategy = Objects.requireNonNull(strategy, "전략");

		//sort(null, 0, 0);

		//Objects.requireNonNull(null);
	}

	private static void sort(long a[], int offset, int length) {
		if(ArrayUtils.isEmpty(a)) {
			System.out.println("비었음");
		}
		assert a != null;
		assert offset >= 0 && offset <= a.length;
		assert length >= 0 && length <= a.length - offset;
	}
}
