package AtividadeUm;
//Entrar com o número e a base em que se deseja calcular o logaritmo desse número e imprimi-lo.

import java.util.Scanner;
import java.lang.Math;
public class AlgoritmoQuarentaEQuatro {

        public static void main(String[] args) {
            double num, base, logaritmo;
            Scanner scan = new Scanner(System.in);

            System.out.print("\nEntre com o logaritmando: ");
            num = scan.nextDouble();
            System.out.print("\nEntre com a base: ");
            base = scan.nextDouble();
            logaritmo = Math.log(num) / Math.log(base);

            System.out.println("\nO logaritmo de " + num + " na base " + base + " é: " + logaritmo);
            System.out.println();
            scan.close();
        }
    }
