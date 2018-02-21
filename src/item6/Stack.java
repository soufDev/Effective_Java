package item6;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public Object pop() {
        if(size==0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    // check if there is enough capacity and double it if there isn't
    private void ensureCapacity() {
        if(elements.length==size)
            elements = Arrays.copyOf(elements, 2 * size +1);
    }

    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] arg) {
        Stack stack = new Stack();
        System.out.println(stack.clone());
    }
}
