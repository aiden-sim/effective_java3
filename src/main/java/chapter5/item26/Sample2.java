package chapter5.item26;

import java.util.ArrayList;
import java.util.List;

/**
 * Object vs Wildcard vs GenericMethod
 */
public class Sample2 {
	public static void main(String[] args) {
		List<String> testList = new ArrayList<String>();
		String s = "Add me!";
		addObjectToList1(testList, s);
		//addObjectToList2(testList, s); // List<Object>가 List<String>의 슈퍼 타입이 아니기 때문에 (무변성) 적용 불가
		addObjectToList3(testList, s);   // 정상
		addObjectToList4(testList, s);

		// 하지만 super는 가능
		List<? super Number> l = new ArrayList<>();
		l.add(Integer.valueOf(3));  //OK
		l.add(Double.valueOf(3.3)); //OK
	}

	/**
	 * Wildcard (비한정) - 실패 (하지만 type은 안전함)
	 */
	private static void addObjectToList1(final List<?> aList, final Object o) {
		//aList.add(o); // 비한정이기 때문에 값을 넣을 수 없다.
	}

	/**
	 * Object - 실패
	 */
	private static void addObjectToList2(final List<Object> aList, final Object o) {
		aList.add(o);   // 컴파일은 성공
	}

	/**
	 * GenericMethod - 성공 (type도 안전함)
	 */
	private static <T> void addObjectToList3(final List<T> aList, final T o) {
		aList.add(o);
	}

	/**
	 * RawType - 성공(하지만 런타임시 안전하지 않음)
	 */
	private static void addObjectToList4(final List aList, final Object o) {
		aList.add(o);
	}
}
