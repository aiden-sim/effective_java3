package generic;

import java.util.List;

/**
 * 제네릭 메서드 vs 와일드카드
 */
public class Sample {
	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4);
		print(list); // 로타입은 허용한다.
		//print2(list); 에러

		A a = new A();
		a.print(list);
		a.print2(list);
		a.print3("test");

		// Object vs Type
		// Object는 형변환이 필요하지만, Type은 형변환이 필요 없다.
		// Type은 컴파일 시점에 안전하다.
		A<String> my = new A<>();
		String result = (String) my.doSomething("test");
		String result2 = my.doSomething2("test");

	}

	// 로(raw) 타입
	public static void print(List l) {

	}

	// 매개변수화 타입
	public static void print2(List<? extends Number> l) {
		//l.add(1); X
	}

	public static <T extends Number> void print3(List<T> t) {
		t.add((T) Integer.valueOf(1));
	}
}

class A<T> {
	public Object doSomething(Object obj) {
		return null;
	}

	public <T> T doSomething2(T t) {
		return t;
	}

	public static <E extends Number> void print(List<E> list) {
		for (E e : list) {
			System.out.println(e);
		}
	}

	public void print2(List<? extends Number> list) {
		for (Number e : list) {
			System.out.println(e);
		}
	}

	public <S> S print3(S s) {
		System.out.println(s);
		return s;
	}
}