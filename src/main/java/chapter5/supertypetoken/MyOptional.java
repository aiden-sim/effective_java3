package chapter5.supertypetoken;

import java.lang.reflect.Type;

public class MyOptional<T> {
	T t;

	private MyOptional(T t) {
		this.t = t;
	}

	public static <T> MyOptional<T> ofNullable(T t) {
		return new MyOptional<>(t);
	}

	public T get() {
		return this.t;
	}

	public Type getTypeName() {
		try {
			return this.getClass().getDeclaredField("t").getType();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] arg) {
		MyOptional<String> stringOptional = MyOptional.ofNullable("hello");
		System.out.println(stringOptional.getTypeName());
	}
}
