package item24;

import java.util.*;

public class Test<T> {
    int size = 0;
    T[] elements;
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // this cast is correct because the array we are creating
            // is of the same type as the one passed in, which is T[]
            @SuppressWarnings("unchecked")
            T[] result =  (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }
        System.arraycopy(elements, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
    public static void main(String[] args) {
        System.out.println("ITEM 24");
    }
}
