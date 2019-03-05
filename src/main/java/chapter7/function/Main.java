package chapter7.function;

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		FunctionSample<String> sample = (s) -> s.length() > 5;
		Predicate<String> predicate = (s) -> s.length() > 5;

		Main main = new Main();
		main.doIt(10);
	}

	public void doIt(int idx) {
		System.out.println(this);

		// 람다
		Runnable lambda = () -> {
			System.out.println(idx + "labda-this : " + this);
		};
		lambda.run();

		// 익명
		Runnable inner = new Runnable() {
			@Override public void run() {
				System.out.println(idx + "inner-this : " + this);
			}
		};
		inner.run();
	}
}
