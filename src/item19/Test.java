package item19;

import static item19.PhysicalConstants.AVOGADRO_NUMBER;

public class Test {
    public static double atoms(double mols) {
        return AVOGADRO_NUMBER * mols;
    }
    public static void main(String[] arg) {

        System.out.println(atoms(12.5));
    }
}
