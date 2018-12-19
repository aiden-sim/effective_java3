package chapter4.item20;

import java.util.Map;
import java.util.Objects;

/**
 * 골격 구현 클래스
 */
public class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
	@Override public V setValue(V value) {
		throw new UnsupportedOperationException();
	}

	@Override public K getKey() {
		return null;
	}

	@Override public V getValue() {
		return null;
	}

	@Override public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Map.Entry)) {
			return false;
		}
		Map.Entry<?, ?> e = (Map.Entry) o;
		return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
	}

	@Override
	public String toString() {
		return getKey() + "=" + getValue();
	}

}
