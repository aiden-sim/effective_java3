package generic;

import java.util.List;
import java.util.Objects;

/**
 * 제네릭 메서드 vs 와일드카드
 */
public class Sample {
	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4);

		A a = new A();
		a.print(list);
		a.print2(list);

		a.print3("test");
	}
}

class A {
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
