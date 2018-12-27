package chapter5.item31;

import java.util.*;

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

    // 와일드카드 타입을 사용하지 않은 pushAll 메서드 (결합있음)
    /*
    public void pushAll(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }
    */

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    // 와일드카드 타입을 사용하지 않은 popAll 메서드 (결함있음)
    /*
    public void popAll(Collection<E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
    */

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(1, 2, 3);
        stack.pushAll(integers);

        Stack<Number> numberStack = new Stack<>();
        Collection<Object> objects = Arrays.asList(1, 2, 3);
        numberStack.popAll(objects);
    }
}

