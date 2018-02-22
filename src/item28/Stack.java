package item28;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
        if(size==0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;
        return result;
    }

    // check if there is enough capacity and double it if there isn't
    private void ensureCapacity() {
        if(elements.length==size)
            elements = Arrays.copyOf(elements, 2 * size +1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // wildCard type for parameter that serves as an E producer
    public void pushAll(Iterable<? extends E> src) {
        for (E e: src)
            push(e);
    }

    // wildCard type for parameter that serves as an E consumer
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }

    @Override
    public String toString() {
        return "Stack{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<Number>();
        Iterable<Integer> integers = new ArrayList<Integer>(Arrays.asList(12, 2, 3));
        numberStack.pushAll(integers);
        System.out.println(numberStack);

        Collection<Object> objects = new ArrayList<>(Arrays.asList("45", 87L, 842.0, "soufiane"));
        numberStack.popAll(objects);
        System.out.println(objects);

    }
}
