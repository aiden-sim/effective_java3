package chapter4.item20.inter;

public class Dog extends Animal implements ITest {

	public static void main(String[] args) {
		Dog dog = new Dog();

		// 인터페이스는 어떤 클래스를 상속했든 같은 타입으로 취급된다.
		if (dog instanceof ITest) {
			System.out.println("A 타입이다");
		}

		if (dog instanceof Dog) {
			System.out.println("Dog 타입이다");
		}

		if (dog instanceof Animal) {
			System.out.println("Animal 타입이다");
		}
	}
}