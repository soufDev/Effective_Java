package item8;

import java.awt.*;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        if (!(o instanceof ColorPoint))
            return o.equals(this);
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] arg) {
        Point p1 = new Point(1, 2);
        ColorPoint p2 = new ColorPoint(1, 2, Color.YELLOW);
        ColorPoint p3 = new ColorPoint(1, 2, Color.GREEN);

        System.out.println(p1.equals(p2)+" - "+p3.equals(p1));
    }
}
