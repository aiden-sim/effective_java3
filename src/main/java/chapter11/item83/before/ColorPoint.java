package chapter11.item83.before;

class Point {
	protected final int x, y;
	private final String name;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		name = makeName();
	}

	protected String makeName() {
		return "[" + x + "," + y + "]";
	}

	public final String toString() {
		return name;
	}
}

public class ColorPoint extends Point {
	private final String color;

	ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	protected String makeName() {
		return super.makeName() + ":" + color;  // final 이지만 초기화 되기전에 오버라이딩 호출이 되서 null이 된다.
	}

	public static void main(String[] args) {
		System.out.println(new ColorPoint(4, 2, "purple"));
	}
}
