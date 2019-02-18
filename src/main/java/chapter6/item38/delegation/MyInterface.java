package chapter6.item38.delegation;

/**
 * 컴포지션을 통한 방식
 */
public interface MyInterface {
	void someMethod();
}

class MyInterfaceImpl implements MyInterface {
	public void someMethod() {
		System.out.println("Do smth...");
	}
}

enum EnumA implements MyInterface {
	AAA;
	private MyInterface impl = new MyInterfaceImpl();

	public void someMethod() {
		impl.someMethod();
	}
}

enum EnumB implements MyInterface {
	BBB;
	private MyInterface impl = new MyInterfaceImpl();

	public void someMethod() {
		impl.someMethod();
	}

}