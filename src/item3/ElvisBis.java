package item3;

public class ElvisBis {
    // create Instance with static factory method
    private static final ElvisBis INSTANCE = new ElvisBis();
    private ElvisBis() {}
    public static ElvisBis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        // destroy
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
