package item20;

public class Rectangle extends Figure {
    final double width;
    final double length;

    Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }
    @Override
    double area() {
        return width * length;
    }
}
