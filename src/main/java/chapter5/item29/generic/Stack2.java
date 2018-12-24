package chapter5.item29.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 제네릭 방법2
 */
public class Stack2<E> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack2() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * push에서 E 타입만 허용하기 때문에 이 형변화는 안전하다.
     */
    public E pop() {
        if (size == 0)
            throw new EmptyStackException();

        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
        Stack2 stack = new Stack2();
        stack.push("test");


        System.err.println(stack.pop());
    }
}
