package item27;

import java.util.*;

public class Test {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    // Generic singleton factory pattern
    private static UnaryFunction<Object> IDENTITY_FUNCTION = new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };

    // IDENTIFY_FUNCTION is stateless and its type parameter is
    // unbounded so it's safe to share one instance across all types.
    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identifyFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTION; // warning
    }

    public <E extends Comparable<? super E>> E max(List<? extends E> list) {
        Iterator<? extends E> i = list.iterator();
        E result = i.next();
        while (i.hasNext()) {
            E e = i.next();
            if (e.compareTo(result) > 0)
                result = e;
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(123, 4));
        Set<Double> s2 = new HashSet<>(Arrays.asList(12.0, 65.63, 87.21));
        Set<Number> result = union(s1, s2);
        System.out.println(result);

        String[] strings = { "aze1", "aze2", "aze3" };
        UnaryFunction<String> sameString = identifyFunction();
        for (String s: strings)
            System.out.println(sameString.apply(s));

        Number[] numbers = { 1, 2.0, 3L };
        UnaryFunction<Number> sameNumber = identifyFunction();
        for (Number n: numbers)
            System.out.println(sameNumber.apply(n));
    }
}
