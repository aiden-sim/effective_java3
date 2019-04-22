package chapter11.item81;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapExample {
	public static void main(String[] args) {
		ConcurrentMap<String, Integer> chm = new ConcurrentHashMap<>();

		System.out.println(chm.put("test", 0)); // null
		System.out.println(chm.put("test", 1)); // 0
		System.out.println(chm.put("test", 2)); // 1

		// null not allowed
		// chm.put(null, null);

		// null allowed
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put(null, null);

		// null allowed
		Map<String, String> synmap = Collections.synchronizedMap(hashMap);
		synmap.put(null, null);

		// null not allowed
		Map<String, String> hashtable = new Hashtable<>();
		// hashtable.put(null, null);
	}
}
