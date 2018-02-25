package item30;

public class WeightTable {

    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("236");
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet p : Planet.values())
            System.out.println("Weight on "+p+" is "+p.surfaceWeight(mass));


    }
}
