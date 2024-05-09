package Exercicio3;

import java.util.Scanner;
public class Exercicio467 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double z, L, b;
        int c;
        for (c = 1; c <= 3; c++) {
            System.out.print("\ndigite logaritmando maior do que 0: ");
            L = scan.nextDouble();
            while (L <= 0) {
                System.out.print("\nInválido. Digite logaritmando maior do que 0: ");
                L = scan.nextDouble();
            }
            System.out.print("\ndigite base maior que 0 e diferente de 1: ");
            b = scan.nextDouble();
            while (b <= 0 || b == 1) {
                System.out.print("\nInválido. Digite base maior que 0 e diferente de 1: ");
                b = scan.nextDouble();
            }
            System.out.printf("\nlogaritmo é %.5f\n", logaritmo(L, b));
            z = logaritmo(L, b);
            System.out.println("z = " + z);
        }
    }

    public static double logaritmo(double base, double expo) {
        double i;
        i = Math.log(base) / Math.log(expo);
        return i;
    }
}