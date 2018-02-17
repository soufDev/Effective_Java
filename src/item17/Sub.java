package item17;

import java.util.Date;

public class Sub extends Super {

    private final Date date;

    public Sub() {
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    public static void main(String[] arg) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
