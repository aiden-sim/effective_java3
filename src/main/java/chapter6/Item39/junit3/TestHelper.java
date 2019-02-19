package chapter6.Item39.junit3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * juniut 방식
 */
public class TestHelper {
	public static void expected(Class<? extends Throwable> expectedClass, TestInterface testable) {
		try {
			testable.test();
			fail("Expected " + expectedClass.getCanonicalName() + " not thrown.");
		} catch (Throwable actual) {
			assertEquals("Expected " + expectedClass.getCanonicalName() + " to be thrown.", expectedClass, actual.getClass());
		}
	}

	interface TestInterface {
		public void test() throws Throwable;
	}

	public static void main(String[] args) {
		expected(
				MyException.class,
				new TestInterface() {
					public void test() throws MyException {
						// 뭔가 테스트
						throw new MyException();
					}
				});
	}
}
