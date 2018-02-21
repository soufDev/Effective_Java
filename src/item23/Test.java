package item23;

import sun.misc.Unsafe;

import java.util.*;

public class Test {

    private static void unsafedAdd(List list, Object o) {
        list.add(o);
    }

    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1: s1)
            if (s1.contains(o1))
                result++;
        return result;
    }
    public static void main(String[] args) {
        // uses Raw type (List) fails at runtime
        List<String> strings = new ArrayList<String>();
        unsafedAdd(strings, "new Integer(42)");
        unsafedAdd(strings, new Integer(42));
        String s = strings.get(0);
    }
}
