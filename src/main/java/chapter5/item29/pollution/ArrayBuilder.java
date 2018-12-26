package chapter5.item29.pollution;

import java.util.Arrays;
import java.util.List;

/**
 * 힙 오염
 */
public class ArrayBuilder {
	public static <T> void addToList (List<T> listArg, T... elements) {
		for (T x : elements) {
			listArg.add(x);
		}
	}

	public static void faultyMethod(List<String>... l) {
		Object[] objectArray = l;     // Valid
		objectArray[0] = Arrays.asList(42);
		String s = l[0].get(0);       // ClassCastException thrown here
	}

	public static void main(String[] args) {
		List<String> list = List.of("test", "test2");
		faultyMethod(list);

	}
}
