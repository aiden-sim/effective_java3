package chapter2.item2.covariant;

public class Execute {
	public static void main(String[] args) {
		new Child().get().message();
	}
}

class Parent {
	Parent get() {
		return this;
	}
}

class Child extends Parent {
	@Override
	Child get() {
		return this;
	}

	void message() {
		System.out.println("HI");
	}
}