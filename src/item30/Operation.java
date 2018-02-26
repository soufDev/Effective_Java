package item30;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    PLUS("+") {
        double apply(double x, double y) { return x + y; }
    }, MINUS("-") {
        double apply(double x, double y) { return x - y; }
    }, TIMES("*") {
        double apply(double x, double y) { return x * y; }
    }, DIVIDE("/") {
        double apply(double x, double y) { return x / y; }
    };

    private static final Map<String, Operation> stringToEnum = new HashMap<>();
    private final String symbol;

    static {
        for (Operation op: values())
            stringToEnum.put(op.toString(), op);
    }

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    public static Operation inverse(Operation operation) {
        switch (operation) {
            case PLUS: return Operation.MINUS;
            case MINUS: return Operation.PLUS;
            case TIMES: return Operation.DIVIDE;
            case DIVIDE: return Operation.TIMES;
            default: throw new AssertionError("Unknown operation: "+operation);
        }
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("4");
        for (Operation op: Operation.values())
            System.out.println(x+" "+op+" "+y+" = "+op.apply(x, y));
        System.out.println(Operation.fromString("*")+"  "+Operation.fromString("er"));
    }
}
