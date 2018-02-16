package item15;

public class Complex {
    private final double re;
    private final double im;

    // constants
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
    public static Complex valueOfPolar(double r, double theta) {
        return new Complex(r * Math.cos(theta), r * Math.sin(theta));
    }
    // accessors without mutator

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    public Complex subtract(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    public Complex multiply(Complex c) {
        return new Complex(re * c.re - im * c.im,
                re * c.im + im * c.re);
    }

    public Complex divide(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re - im * c.im) / tmp,
                (re * c.im + im * c.re) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17 + hashDouble(re);
        result = 31 * result + hashDouble(im);
        return result;
    }

    // error in the book they mention re inside the function instead of val ;)
    private int hashDouble(double val) {
        long longBits = Double.doubleToLongBits(val);
        return (int) (longBits ^ (longBits >>> 32));
    }

    @Override
    public String toString() {
        return "(" + re +  " + " + im + "i)";
    }

    public static void main(String[] arg) {
        Complex c = Complex.valueOf(20, 50);
        Complex c1 = Complex.valueOf(20, 50);
        c = c.add(c1);
        System.out.println("add => "+c);
        c = c.subtract(c1);
        System.out.println("subtract => "+c);
        c = c.multiply(c1);
        System.out.println("multiply => "+c);
        c = c.divide(c1);
        System.out.println("divide => "+c);
    }
}
