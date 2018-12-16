package chapter4.item18.extend;

import java.util.Collection;
import java.util.HashSet;

/**
 * 잘못된 상속의 예
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    // 추가된 원소의 수
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    // 해당 메서드를 재정의하지 않으면 문제를 고칠 수 있다.
    // 하지만 HashSet의 addAll이 add 메서드를 이용해 구현했음을 가정한 해법이라는 한계를 지닌다.
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    // 요구 조건 : 생성 이후, 원소가 몇 개 더해졌는지 알 수 있어야 한다.
    public int getAddCount() {
        return addCount;
    }
}
