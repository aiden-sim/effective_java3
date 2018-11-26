package chapter2.item7;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapSample {
	public static void main(String[] args) {
		Map<Integer, Integer> m1 = new WeakHashMap<Integer, Integer>();

		Integer key1 = new Integer(10);   // used as keys
		Integer key2 = new Integer(20);

		Integer key3 = new Integer(30);    // used as values
		Integer key4 = new Integer(40);

		m1.put(key1, key3);
		m1.put(key2, key4);

		System.out.println("Value of key1: " + m1.get(key1));
		System.out.println("Value of key2: " + m1.get(key2));

		key1 = null;      // equivalent of not using in the remaining part of code
		System.gc();   // let us see most probably garbage collection takes place.
		//This statement is not required with high speed processor

		System.out.println("Value of key1: " + m1.get(key1));
		System.out.println("Value of key2: " + m1.get(key2));
	}
}
