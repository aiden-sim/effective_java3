package chapter7.item44;

import java.util.Map;

/**
 * java.util.function에 표준 함수형 인터페이스를 제공한다. 그것을 사용해라
 */
@FunctionalInterface
public interface EldestEntryRemovalFunction<K, V> {
    boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
}
