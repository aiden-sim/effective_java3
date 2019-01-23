package chapter5.item26;

import java.util.*;

public class Sample {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		unsafeAdd(strings, Integer.valueOf(42));
		//String s = strings.get(0); // ClassCastException
		//System.out.println(s);

		// 이거는 허용 안함
		List<?> list = new ArrayList<>();
		// list.add("verboten");

		// 이건 허용 함
		List<?> list2 = new ArrayList<String>();

		// 이거는 허용함
		List<Object> list3 = new ArrayList<>();
		list3.add("test");
		list3.add(10);

		// wildcard instanceOf
		instanceOf(strings);
	}

	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}

	private static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object o1 : s1) {
			if (s2.contains(o1)) {
				result++;
			}
		}
		return result;
	}

	// 예외
	private static void instanceOf(List<String> list) {
		if (list instanceof List<?>) {
			System.out.println("비한정 와일드카드 적용");
		}

		if (list instanceof List) {
			System.out.println("로 타입 적용");
		}

		// 컴파일 에러
/*        if(list instanceof List<String>) {

        }*/
	}
}
