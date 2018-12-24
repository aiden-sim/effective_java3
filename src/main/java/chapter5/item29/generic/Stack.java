package chapter5.item29.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 제네릭 방법1
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * private 필드에 저장되어 있고 다른 메서드에 전달되는 일이 전혀 없기 때문에 안전하다.
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
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
        Stack stack = new Stack();
        stack.push("test");


        System.err.println(stack.pop());
    }
}
