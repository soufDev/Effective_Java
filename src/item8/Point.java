package item8;

import java.util.HashSet;
import java.util.Set;

public class Point {
    private final int x;
    private final int y;
    // initialize UnitCircle
    private static final Set<Point> unitCircle;
    static {
        unitCircle = new HashSet<Point>();
        unitCircle.add(new Point(1, 0));
        unitCircle.add(new Point(0, 1));
        unitCircle.add(new Point(-1, 0));
        unitCircle.add(new Point(0, -1));
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o==null || o.getClass() != getClass())
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    public static void main(String[] arg) {
        Point p = new Point(1, 0);
        System.out.println(p.equals(new Point(-1, 0)));
    }
}
