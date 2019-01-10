package chapter7.item47;

import java.util.*;

/**
 * 입력 집합의 멱집합을 전용 컬렉션에 담아 반환한다.
 * 코드는 지저분해졌지만, 스트림을 활용한 구현보다 1.4배 빨랐다고 한다(책에서)
 */
public class PowerSet {
	public static final <E> Collection<Set<E>> of(Set<E> s) {
		List<E> src = new ArrayList<>(s);
		if (src.size() > 30)
			throw new IllegalArgumentException(
					"집합에 원소가 너무 많습니다(최대 30개).: " + s);

		return new AbstractList<Set<E>>() {
			@Override public int size() {
				return 1 << src.size();
			}

			@Override public boolean contains(Object o) {
				return o instanceof Set && src.containsAll((Set) o);
			}

			@Override public Set<E> get(int index) {
				Set<E> result = new HashSet<>();
				for (int i = 0; index != 0; i++, index >>= 1) {
					if ((index & 1) == 1) {
						result.add(src.get(i));
					}
				}
				return result;
			}
		};
	}
}
