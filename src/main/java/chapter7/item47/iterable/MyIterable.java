package chapter7.item47.iterable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyIterable<T> implements Iterable<T> {

    private List<T> list;

    public MyIterable(T[] t) {
        list = Arrays.asList(t);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}