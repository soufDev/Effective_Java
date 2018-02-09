import item2.NutritionFacts;

public class Main {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        long sum = 0;
        for(long i=0; i< Integer.MAX_VALUE ; i++)
            sum += i;
        System.out.println("time: "+(System.currentTimeMillis()-time) );
        System.out.println("sum: "+sum);

        int j = 0;
        System.out.println("j = "+(j++));
        System.out.println("j = "+(j));

    }
}
