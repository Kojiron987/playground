package play.generics;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null; // 使われなくなった参照を取り除く
        return result;
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

    private void ensureCapacity() {
        if (isEmpty())  {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
