package Exercicio3;

import java.util.Scanner;

public class Exercicio483 {

    public static void main(String[] args) {
        int[] vetorA = new int[4];
        int[] vetorB = new int[4];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o " + (i + 1) + "º número do vetor A: ");
            vetorA[i] = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o " + (i + 1) + "º número do vetor B: ");
            vetorB[i] = scanner.nextInt();
        }

        int produtoInterno = calcularProduto(vetorA, vetorB, 4);

        System.out.println("\nVetor A\tVetor B");
        for (int i = 0; i < 4; i++) {
            System.out.println(vetorA[i] + "\t" + vetorB[i]);
        }
        System.out.println("\nProduto interno: " + produtoInterno);
    }

    public static int calcularProduto(int[] vetorA, int[] vetorB, int tamanho) {
        int produtoInterno = 0;
        for (int i = 0; i < tamanho; i++) {
            produtoInterno += vetorA[i] * vetorB[i];
        }
        return produtoInterno;
    }

}
