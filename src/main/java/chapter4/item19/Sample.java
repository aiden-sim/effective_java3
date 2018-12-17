package chapter4.item19;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");

		// sub는 ArrayList clear는 AbstractList
		list.subList(0, 1).clear();
	}
}
