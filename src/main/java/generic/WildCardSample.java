package generic;

public class WildCardSample {
	public static void main(String[] ar) {
		WildCardSample ex = new WildCardSample();
		ex.callWildCardMethod();
	}

	public void callWildCardMethod() {
		WildCardGeneric<String> wildcard = new WildCardGeneric<String>();
		wildcard.setWildCard("A");
		wildcardStringMethod(wildcard);
		// A

		wildcardStringMethod2(wildcard);
		// A

		WildCardGeneric<Integer> wildcard2 = new WildCardGeneric<Integer>();
		wildcard2.setWildCard(777);
		wildcardStringMethod2(wildcard2);
		// 777

	}

	public void wildcardStringMethod(WildCardGeneric<String> c) {
		String value = c.getWildCard();
		System.out.println(value);
	}

	// wildcard 에는 어떤 타입이라도 들어갈 수 있다.
	public void wildcardStringMethod2(WildCardGeneric<?> c) {
		Object value = c.getWildCard();
		System.out.println(value);
	}
}