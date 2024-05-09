package Exercicio3;
import java.util.Scanner;

public class Exercicio499 {

        public static void main(String[] args) {
            int[] num = new int[5];
            int flag = 0, op;

            Scanner scan = new Scanner(System.in);

            do {
                System.out.println("\n\n\n");
                System.out.println("MENU VETOR - FUNCAO");
                System.out.println("\n1 Dados do VETOR");
                System.out.println("2 Ordena VETOR");
                System.out.println("3 Imprime VETOR");
                System.out.println("4 Sai do programa");
                System.out.print("\nOPCAO: ");
                op = scan.nextInt();

                switch (op) {
                    case 1 -> {
                        entrada(num, 5);
                        flag = 1;
                    }
                    case 2 -> {
                        if (flag == 1) {
                            ordena(num, 5);
                        } else {
                            System.out.println("\nEscolha primeiro opcao 1");
                        }
                    }
                    case 3 -> {
                        if (flag == 1) {
                            imprime(num, 5);
                        } else {
                            System.out.println("\nEscolha primeiro opcao 1");
                        }
                    }
                    case 4 -> System.out.println("\nSaindo do Algoritmo");
                    default -> System.out.println("\nOpcao invalida");
                }

            } while (op != 4);

            System.out.println();
        }

        public static void entrada(int[] vet, int t) {
            Scanner input = new Scanner(System.in);

            System.out.println("\nEntrada do VETOR");
            for (int L = 0; L < t; L++) {
                System.out.print("Digite numero " + (L + 1) + ": ");
                vet[L] = input.nextInt();
            }

        }

        public static void imprime(int[] vet, int t) {
            System.out.println("\nVETOR");
            for (int L = 0; L < t; L++) {
                System.out.println(" " + (L + 1) + " " + vet[L]);
            }
        }

        public static void ordena(int[] vet, int tam) {
            int temp;

            for (int i = 0; i < tam - 1; i++) {
                for (int j = i + 1; j < tam; j++) {
                    if (vet[i] > vet[j]) {
                        temp = vet[i];
                        vet[i] = vet[j];
                        vet[j] = temp;
                    }
                }
            }

            System.out.println("\nVETOR ORDENADO");
            for (int L = 0; L < tam; L++) {
                System.out.println(" " + (L + 1) + " " + vet[L]);
            }
        }
}