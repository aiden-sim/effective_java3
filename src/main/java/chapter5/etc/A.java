package chapter5.etc;

import java.util.ArrayList;
import java.util.List;

/**
 * 제네릭 메서드 테스트
 */
public class A<T> {
	T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static <T> List<T> getList(T t) {
		List<T> list = new ArrayList<>();
		list.add(t);
		return list;
	}

	public <U> List<U> print(U u) {
		List<U> list = new ArrayList<>();
		return list;
	}

	public static void main(String[] args) {
		A<String> a = new A<>();
		a.set("test");
		System.out.println(a.get());
	}

}
