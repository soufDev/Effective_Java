package item8;

import java.util.ArrayList;
import java.util.List;

public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        if (s==null)
            throw new NullPointerException();
        this.s = s;
    }


    @Override
    public boolean equals(Object o) {
        // broke symmetry
//        if (o instanceof CaseInsensitiveString)
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        if (o instanceof String)
//            return s.equalsIgnoreCase((String) o);
//        return false;
        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

    public static void main(String[] arg) {
        CaseInsensitiveString o1 = new CaseInsensitiveString("o1"),
                o2 = new CaseInsensitiveString("o1");
        String s1 = "o1";
        System.out.println(o1.equals(o2)+ " - " + o2.equals(o1));
        List<CaseInsensitiveString> list = new ArrayList<CaseInsensitiveString>();
        list.add(o1);
        System.out.println(list.contains(o1));
    }
}
