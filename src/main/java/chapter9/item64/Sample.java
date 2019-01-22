package chapter9.item64;

import java.util.*;

public class Sample {
	public static void main(String[] args) {
		// 좋은 예
		Set<String> set = new LinkedHashSet<>();

		// 나쁜 예
		LinkedHashSet<String> set2 = new LinkedHashSet<>();
	}
}
