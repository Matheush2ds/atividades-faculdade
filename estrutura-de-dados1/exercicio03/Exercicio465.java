package Exercicio3;

import java.util.Scanner;
public class Exercicio465 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        System.out.print("Digite o primeiro número: ");
        num1 = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        num2 = scanner.nextInt();
        System.out.print("Digite o terceiro número: ");
        num3 = scanner.nextInt();
        maiorNumero(num1, num2, num3);
    }

    public static void maiorNumero(int num1, int num2, int num3) {
        int maior = num1;
        if (num2 > maior) {
            maior = num2;
        }
        if (num3 > maior) {
            maior = num3;
        }
        System.out.println("O maior número é: " + maior);
    }
}