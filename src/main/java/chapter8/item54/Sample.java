package chapter8.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sample {
	private final List<String> cheesesInStock = new ArrayList<>();

	// 컬렉션이 비었으면 null을 반환한다. - 따라 하지 말것
	public List<String> getCheeses() {
		return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
	}

	// 빈 컬렉션을 반환하는 올바른 예
	// 반환 값 - private static final Object[] EMPTY_ELEMENTDATA = {};
	public List<String> getCheeses2() {
		return new ArrayList<>(cheesesInStock);
	}

	// 빈 컬렉션을 매번 새로 할당하지 않도록 함
	public List<String> getCheeses3() {
		return cheesesInStock.isEmpty() ? Collections.emptyList() : new ArrayList<>(cheesesInStock);
	}

	// 길이가 0일 수도 있는 배열을 반환하는 올바른 방법
	public String[] getCheeses4() {
		return cheesesInStock.toArray(new String[0]);
	}
}
