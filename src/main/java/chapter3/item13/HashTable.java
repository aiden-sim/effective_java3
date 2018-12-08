package chapter3.item13;

public class HashTable implements Cloneable {
    private Entry[] buckets = new Entry[10];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // CASE2) 링크드 리스트 전체 복사하기 위해 재귀적으로 호출한다.
        // 재귀 호출 때문에 리스트의 원소 수만큼 스택 프레임을 소비하여, 리스트가 길면 오버플로우 일으킬 위험
        /*
        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }
        */

        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for(Entry p = result; p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    /*
    CASE1) 이렇게 하면 하위 buckets 내부의 주소값이 공유되서 영향을 준다.
    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    */

    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        HashTable table = new HashTable();

        Entry last = new Entry("key2", "value2", null);
        Entry first = new Entry("key", "value", last);

        table.buckets[0] = first;
        table.buckets[1] = last;

        HashTable table2 = table.clone();
    }
}
