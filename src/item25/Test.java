package item25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test<T> {

    static <T> T reduce(List<T> list, Function<T> f, T initVal) {
        List<T> snapshot; // locks list internally
        synchronized (list) {
            snapshot = new ArrayList<T>(list);
        }
        T result = initVal;
        for (T o : snapshot)
            result = f.apply(result, o);
        return result;
    }
    interface Function<T> {
        T apply(T arg1, T arg2);
    }

    public static void main(String[] args) {
        //Object[] objectArray = new Long[1];
        // will throw ArrayStoreException
        // objectArray[0] = "I don't fit in";
        // will not compile
        // List<Object> ol = new ArrayList<Long>(); // Incompatible Types

        // why generic array creation is illegal - won't compile!
//        List<String>[] stringsLists = new List<String>[1];
//        List<Integer> intList = Arrays.asList(42);
//        Object[] objects = stringsLists;
//        Object[0] = intList;
//        String s = stringsLists[0].get(0);

    }
}
