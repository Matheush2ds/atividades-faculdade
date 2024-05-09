package Exercicio3;

import java.util.Scanner;
public class Exercicio471 {

    public static void main(String[] args) {
        int num, numl, n;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dividendo: ");
        num = scanner.nextInt();

        System.out.print("Digite o divisor: ");
        numl = scanner.nextInt();

        while (numl > num) {
            System.out.print("INVALIDO. Digite numero menor do o dividendo: ");
            numl = scanner.nextInt();
        }

        // chama a funcao divisor
        n = divisor(num, numl);

        if (n == 0) {
            System.out.println("Nenhuma vez");
        } else {
            System.out.println("Numero de vezes: " + n);
        }
    }

    public static int divisor(int x, int y) {
        int r, n = 0;
        r = x % y;
        while (r == 0) {
            n++;
            x = x / y;
            r = x % y;
        }
        return n;
    }
}