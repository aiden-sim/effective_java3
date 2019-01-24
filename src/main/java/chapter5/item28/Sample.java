package chapter5.item28;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	public static void main(String[] args) {
		// 공변성
		A[] aArray = new A[10];
		B[] bArray = new B[10];
		aArray = bArray;

		// 배열을 비한정적 와일드카드 타입
		List<String> first = new ArrayList<>();
		first.add("test");

		List<?>[] list = new ArrayList<?>[10];
		list[0] = first;

		// 불공변성
		List<A> aList = new ArrayList<>();
		List<B> bList = new ArrayList<>();
		//aList = bList; // 에러남

		// 제네릭 배열 생성을 허용하지 않는 이유
/*        List<String>[] stringLists = new List<String>[1];
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        String s = stringLists[0].get(0);*/
	}
}

class A {

}

class B extends A {

}
