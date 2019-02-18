package chapter6.item38.helpermethod;

import chapter6.item38.BasicOperation;
import chapter6.item38.ExtendedOperation;
import chapter6.item38.Operation;

/**
 * value를 통해 enum을 가지고 오는 helper method
 */
public class Helper {
	public static <E extends Enum<E> & Operation> E getEnumItem(Class<E> type, String value) {
		for (E constant : type.getEnumConstants()) {
			if (constant.getSymbol().equals(value)) {
				return constant;
			}
		}
		throw new IllegalArgumentException("no constant with " + value + " in " + type);
	}

	public static void main(String[] args) {
		BasicOperation result = getEnumItem(BasicOperation.class, "+");
		System.out.println(result);

		ExtendedOperation result2 = getEnumItem(ExtendedOperation.class, "^");
		System.out.println(result2);
	}
}
