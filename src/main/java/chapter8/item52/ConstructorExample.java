package chapter8.item52;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

/**
 * 생성자 오버로딩도 컴파일 시점에 선택되기 때문에 안전하지 않다.
 */
public class ConstructorExample {

	public ConstructorExample(Set<?> s) {
		System.out.println("집합");
	}

	public ConstructorExample(List<?> s) {
		System.out.println("리스트");
	}

	public ConstructorExample(Collection<?> s) {
		System.out.println("그 외");
	}

	public static void main(String[] args) {
		Collection<?>[] collections = {
				new HashSet<String>(),
				new ArrayList<BigInteger>(),
				new HashMap<String, String>().values()
		};

		for (Collection<?> c : collections) {
			System.out.println(new ConstructorExample(c));
		}
	}
}
