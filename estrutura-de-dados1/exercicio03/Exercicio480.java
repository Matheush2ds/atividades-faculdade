package Exercicio3;
import java.util.Scanner;
public class Exercicio480 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Digite um número: ");
            int n = sc.nextInt();
            int x = reverso(n);
            System.out.println(n + " - " + x);
            if (x == n) {
                System.out.println("É um número capicua");
            } else {
                System.out.println("Não é um número capicua");
            }
        }

        public static int reverso(int n) {
            int rev = 0;
            while (n != 0) {
                rev = rev * 10 + n % 10;
                n = n / 10;
            }
            return rev;
        }

}
