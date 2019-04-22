package chapter10.item73;

public class Sample {

	public static void test() throws LowerLevelException {

	}

	public static void main(String[] args) throws HigherLevelException {
		try {
			test();
		} catch (LowerLevelException cause) {
			throw new HigherLevelException(cause);
		}
	}
}
