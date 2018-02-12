package item11;


public class HashTable implements Cloneable {
    private Entry[] buckets = new Entry[8];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone();
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
