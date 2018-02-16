package item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class InstrumentedHashSet<E> extends ForwardingSet<E> {

    // count how many time we attempted element's insertion
    private int addCount = 0;

    public InstrumentedHashSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addCount += collection.size();
        return super.addAll(collection);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] arg) {
        Set<String> s = new HashSet<String>(8);
        InstrumentedHashSet<String> inst = new InstrumentedHashSet<String>(s);
        inst.addAll(Arrays.asList("s1", "s2", "s3", "s4"));
        System.out.println(inst.getAddCount());
    }
}
