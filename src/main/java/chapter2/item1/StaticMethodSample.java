package chapter2.item1;

public class StaticMethodSample {

	private String name;

	public StaticMethodSample(String name) {
		this.name = name;
	}

	public static String getName() {
		return "static method";
	}

	public static StaticMethodSample getInstance() {
		return new StaticMethodSample("static factory method");
	}
}
