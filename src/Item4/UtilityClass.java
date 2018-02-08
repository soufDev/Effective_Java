package Item4;

public class UtilityClass {

    // make constructor to private and throw an exception if there is inside invocation
    private UtilityClass() {
        throw new AssertionError();
    }

}
