package chapter2.item7.referred;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapTest {
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<>();
		Map<String, String> weakHashMap = new WeakHashMap<>();

		String keyHashMap = new String("keyHashMap");
		String keyWeakHashMap = new String("keyWeakHashMap");

		hashMap.put(keyHashMap, "Ankita");
		weakHashMap.put(keyWeakHashMap, "Atul");
		System.gc();
		System.out.println("Before: hash map value : " + hashMap.get("keyHashMap") + " and weak hash map value : " + weakHashMap.get("keyWeakHashMap"));

		keyHashMap = null;
		keyWeakHashMap = null;


		System.gc();
		System.out.println("After: hash map value : " + hashMap.get("keyHashMap") + " and weak hash map value : " + weakHashMap.get("keyWeakHashMap"));
	}
}
