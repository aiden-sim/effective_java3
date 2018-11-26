package chapter2.item6;

// 런타임에서 Object가 된다.
public class Container<T> {

	private T data;

	public T getData() {
		return data;
	}

	public static void main(String[] args) {
		System.out.println("test");
	}
}