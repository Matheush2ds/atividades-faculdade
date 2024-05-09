package AtividadeUm;

import java.util.Scanner;
import java.lang.Math;

//Entrar com um número e imprimir o logaritmo desse número na base 10.
public class AlgoritmoQuarentaETres {
    public static void main(String[] args) {
        double num, logaritmo;
        Scanner scan = new Scanner(System.in);

        System.out.print("\nEntre com o logaritmando: ");
        num = scan.nextDouble();
        logaritmo = Math.log(num) / Math.log(10);

        System.out.println("\nLogaritmo: " + logaritmo);
        System.out.println();
        scan.close();
    }
}
