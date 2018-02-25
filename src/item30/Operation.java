package item30;

public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    double apply(double x, double y) {
        switch (this) {
            case PLUS: return x+y;
            case MINUS: return x-y;
            case DIVIDE: return x/y;
            case TIMES: return x*y;
        }
        throw new AssertionError("Unknown op: "+ this);
    }
}
