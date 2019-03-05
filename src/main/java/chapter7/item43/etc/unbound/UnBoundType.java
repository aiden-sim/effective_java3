package chapter7.item43.etc.unbound;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class UnBoundType {

	// instance method
	public int cubic(int a) {
		return a * a * a;
	}

	public boolean testMethod(boolean falg) {
		return falg;
	}

	public static void main(String[] args) {
		UnBoundType cal = new UnBoundType();

		// Using a lambda expression
		BiFunction<UnBoundType, Integer, Integer> operator = (a, b) -> a.cubic(b);
		System.out.println(operator.apply(cal, 6));

		// Using a method reference (UnBound type)
		BiFunction<UnBoundType, Integer, Integer> operator2 = UnBoundType::cubic;
		System.out.println(operator2.apply(cal, 6));

		BiPredicate<UnBoundType, Boolean> predicate = UnBoundType::testMethod;
		System.out.println(predicate.test(cal, true));
	}
}