package chapter7.item44;


import java.util.LinkedHashMap;
import java.util.Map;

public class CustomLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private CustomLinkedHashMap() {
    }

    // 맵의 원소가 100개가 될때까지 커지다가, 그 이상이 되면 오래된 원소를 하나씩 제거한다.
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > 100;
    }
}
