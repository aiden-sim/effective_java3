package chapter10.item69;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Sample {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("test", "test2", "test3");

		for (Iterator<String> i = list.iterator(); i.hasNext(); ) { // hasNext는 상태검사 메서드
			String s = i.next(); // 상태 의존적 메서드
		}

		// 잘못된 순회
		try {
			Iterator<String> i = list.iterator();
			while (true) {
				String s = i.next();
			}
		} catch (NoSuchElementException e) {

		}

	}
}
