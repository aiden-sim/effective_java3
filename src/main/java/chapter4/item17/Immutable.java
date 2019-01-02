package chapter4.item17;

public final class Immutable implements Cloneable {
	private final int id;
	private final String name;

	public Immutable(int id, String name) {
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public Immutable clone() throws CloneNotSupportedException {
		return (Immutable)super.clone();
	}
}
