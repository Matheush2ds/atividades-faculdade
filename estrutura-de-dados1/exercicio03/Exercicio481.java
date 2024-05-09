package Exercicio3;

import java.util.Scanner;

public class Exercicio481 {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int num, base;
            System.out.print("Digite um numero maior ou igual a 0: ");
            num = scan.nextInt();
            while (num < 0) {
                System.out.print("Numero negativo. Digite um numero maior ou igual a 0: ");
                num = scan.nextInt();
            }
            System.out.print("Digite a base em que deseja representa-lo (2-10): ");
            base = scan.nextInt();
            while (base < 2 || base > 10) {
                System.out.print("Nao sei converter. Digite a base em que deseja representa-lo (2-10): ");
                base = scan.nextInt();
            }
            int result = converte(num, base);
            System.out.println("Numero em decimal: " + num);
            System.out.println("Numero na base " + base + ": " + result);
        }

        public static int converte(int num, int base) {
            int nb = 0, b = 0;
            while (num >= base) {
                int r = num % base;
                nb += Math.pow(10, b) * r;
                num /= base;
                b++;
            }
            nb += Math.pow(10, b) * num;
            return nb;
        }

}
