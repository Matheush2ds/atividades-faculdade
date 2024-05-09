package Exercicio3;

import java.util.Scanner;
public class Exercicio493 {

        public static void main(String[] args) {
            int[] num = new int[10];
            Scanner scan = new Scanner(System.in);

            for (int i = 0; i < 10; i++) {
                System.out.print("Digite número " + (i+1) + ": ");
                num[i] = scan.nextInt();
            }

            int ordem = verificaOrdem(num, 10);
            if (ordem == 1) {
                System.out.println("\nORDENAÇÃO CRESCENTE");
            } else if (ordem == 2) {
                System.out.println("\nORDENAÇÃO DECRESCENTE");
            } else {
                System.out.println("\nNÃO ESTÁ ORDENADO");
            }
        }

        public static int verificaOrdem(int[] vetor, int tamanho) {
            int crescente = 1;
            int decrescente = 2;
            int naoOrdenado = 0;
            boolean ordemCrescente = true;
            boolean ordemDecrescente = true;

            for (int i = 0; i < tamanho - 1; i++) {
                if (vetor[i] > vetor[i+1]) {
                    ordemCrescente = false;
                } else if (vetor[i] < vetor[i+1]) {
                    ordemDecrescente = false;
                }
            }

            if (ordemCrescente) {
                return crescente;
            } else if (ordemDecrescente) {
                return decrescente;
            } else {
                return naoOrdenado;
            }
        }
}