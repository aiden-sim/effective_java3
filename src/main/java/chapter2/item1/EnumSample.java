package chapter2.item1;

public enum EnumSample {
	APPLE(0),
	BANANA(1),
	MELON(2);

	private int value;

	EnumSample(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}