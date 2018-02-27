package item33;

import java.util.*;

public class Herb {
    public enum Type { ANNUAL, PERENNIAL, BIENNIAL }

    private final String name;
    private final Type type;

    Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        Herb[] garden = new Herb[]{new Herb("herb1", Type.ANNUAL), new Herb("herb2", Type.BIENNIAL),
                new Herb("herb3", Type.PERENNIAL), new Herb("herb4", Type.ANNUAL)};
        Map<Type, Set<Herb>> herbsByType = new EnumMap<Type, Set<Herb>>(Type.class);
        for (Type t: Type.values()) {
            herbsByType.put(t, new HashSet<Herb>());
        }
        for (Herb h: garden) {
            herbsByType.get(h.type).add(h);
        }
        // print the result
        System.out.println(herbsByType);
    }
}
