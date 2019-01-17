package chapter4.item20;

/**
 * interface 형태의 템플릿 메서드 패턴의 문제
 * execute를 override 하면 잘못된 동작이 될 수 있다.
 */
public interface A {

	void phase1();

	void phase2();

	default void execute() {
		phase1();
		phase2();
	}
}

class B implements A {
	@Override public void phase1() {
		System.out.println("A");
	}

	@Override public void phase2() {
		System.out.println("B");
	}

	@Override
	public void execute() {
		phase2();
		phase1();
	}

	public static void main(String[] args) {
		B b = new B();
		b.execute();
	}
}