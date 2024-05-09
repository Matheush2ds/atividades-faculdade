package Exercicio3;

import java.util.Scanner;
public class Exercicio460 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int num, dobro;
            for (int i = 0; i < 3; i++) {
                System.out.print("Digite um número: ");
                num = scanner.nextInt();
                dobro = dob(num);
                System.out.println("O dobro de " + num + " é " + dobro);
            }
        }

        public static int dob(int x) {
            return x * 2;
        }
    }