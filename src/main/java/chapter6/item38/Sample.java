package chapter6.item38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Sample {
	public static void main(String[] args) {
		double x = 4;
		double y = 2;

		test(ExtendedOperation.class, x, y);
		test(Arrays.asList(ExtendedOperation.values()), x, y);

		Collection<Operation> operationList = new ArrayList<>();
		operationList.addAll(Arrays.asList(ExtendedOperation.values()));
		operationList.addAll(Arrays.asList(BasicOperation.values()));
		test(operationList, x, y);
	}

	/**
	 * case1) 한정적 타입 토큰 역할
	 */
	private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
		for (Operation op : opEnumType.getEnumConstants()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}

	/**
	 * case2) 한정적 와일드카드 타입
	 */
	private static void test(Collection<? extends Operation> opSet, double x, double y) {
		for (Operation op : opSet) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}
}
