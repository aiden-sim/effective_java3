package generic;

public class GenericWildcardSample {
	public static void main(String[] ar) {
		GenericWildcardSample ex = new GenericWildcardSample();
		ex.callGenericMethod();
	}

	public void callGenericMethod() {
		WildCardGeneric<String> wildcard = new WildCardGeneric<String>();
		genericMethod(wildcard, "Teemo");
	}

	public <T> void genericMethod(WildCardGeneric<T> c, T addValue) {
		c.setWildCard(addValue);
		T value = c.getWildCard();
		System.out.println(value);
		// Teemo
	}
}
