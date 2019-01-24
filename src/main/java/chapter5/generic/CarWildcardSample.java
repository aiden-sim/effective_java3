package chapter5.generic;

public class CarWildcardSample {
	public static void main(String[] ar) {
		CarWildcardSample ex = new CarWildcardSample();
		ex.callBoundedWildcardMethod();
		ex.callBusBoundedWildcardMethod();
	}

	public void callBoundedWildcardMethod() {
		WildCardGeneric<Car> wildcard = new WildCardGeneric<Car>();
		wildcard.setWildCard(new Car("Mustang"));
		boundedWildcardMethod(wildcard);
		// Car name = Mustang
	}

	public void callBusBoundedWildcardMethod() {
		WildCardGeneric<Bus> wildcard = new WildCardGeneric<Bus>();
		wildcard.setWildCard(new Bus("7777"));
		boundedWildcardMethod(wildcard);
		// Bus name = 7777
	}

	// wildcared를 사용해서 타입범위를 조절했다.
	public void boundedWildcardMethod(WildCardGeneric<? extends Car> c) {
		Car value = c.getWildCard();
		System.out.println(value);
	}
}
