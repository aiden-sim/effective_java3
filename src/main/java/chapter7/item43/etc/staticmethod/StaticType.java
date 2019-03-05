package chapter7.item43.etc.staticmethod;

import java.util.function.Function;

public class StaticType {
	// instance method
	public static int cubic(int a) {
		return a * a * a;
	}

	public static void main(String[] args) {
		Function<Integer, Integer> operator = (a) -> cubic(a);
		System.out.println(operator.apply(2));

		// Using a method reference (bound type)
		Function<Integer, Integer> operator2 = StaticType::cubic;
		System.out.println(operator2.apply(3));

	}
}
