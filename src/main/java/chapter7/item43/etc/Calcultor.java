package chapter7.item43.etc;

import java.util.function.BiFunction;

public class Calcultor {

	public int plus(int a) {
		return a;
	}

	public static void main(String[] args) {
		Calcultor calcultor = new Calcultor();
		calcultor.test();
	}

	private void test() {
		Calcultor calcultor = new Calcultor();
		BiFunction<Calcultor, Integer, Integer> bf = (a, b) -> a.plus(b);
		System.out.println(bf.apply(calcultor, 10));
	}
}
