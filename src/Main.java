import item2.NutritionFacts;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        NutritionFacts pespi = new NutritionFacts.Builder(215, 56)
                .sodium(125)
                .calories(356)
                .build();
        System.out.println(pespi.toString());
    }
}
