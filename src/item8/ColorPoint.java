package item8;

import java.awt.*;

public class ColorPoint {
    private final Color color;
    private final Point point;

    public ColorPoint(int x, int y, Color color) {
        if(color==null)
            throw new NullPointerException();
        this.point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }

    public static void main(String[] arg) {
        Point p1 = new Point(1, 2);
        ColorPoint p2 = new ColorPoint(1, 2, Color.YELLOW);
        ColorPoint p3 = new ColorPoint(1, 2, Color.GREEN);

        System.out.println(p1.equals(p2)+" - "+p3.equals(null));
    }
}
