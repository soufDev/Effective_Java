package item21;

import java.io.Serializable;

public class Host {
    private static class StrLenCmp implements Comparator<String>, Serializable {

        @Override
        public int compare(String t1, String t2) {
            return t1.length() - t2.length();
        }
    }

    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();

    public static void main(String[] args) {
        System.out.println(
                STRING_LENGTH_COMPARATOR.compare("azeaze", "azezazeaze"));
    }
}
