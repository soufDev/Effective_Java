package item11;


import java.util.Arrays;

public class HashTable implements Cloneable {
    private Entry[] buckets = new Entry[]{};

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // copy the linked list header by this entry
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for (Entry p = result ; p.next != null ; p = p.next)
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            return result;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "buckets=" + Arrays.toString(buckets) +
                '}';
    }

    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0 ; i<buckets.length ; i++)
                if (buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }


    }

    public static void main(String[] arg) {
        HashTable ht = new HashTable();
        System.out.println("ht " + ht);
        System.out.println("ht clone" + ht.clone());
    }
}
