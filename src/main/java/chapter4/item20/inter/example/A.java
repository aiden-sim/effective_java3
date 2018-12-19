package chapter4.item20.inter.example;

public interface A {
	boolean equals(Object o);

	int hashCode();
}

class B implements A {

	@Override
	public boolean equals(Object o) {
		return true;
	}

	@Override
	public int hashCode() {
		return 0;
	}
}