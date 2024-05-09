package Exercicio3;
import java.util.Arrays;

public class Exercicio497 {

        public static void main(String[] args) {
            int[] vetor = new int[10];
            int busca, posicao;

            for (int i = 0; i < vetor.length; i++) {
                System.out.print("Digite o número " + (i + 1) + ": ");
                vetor[i] = Integer.parseInt(System.console().readLine());
            }

            // ordenação do vetor
            Arrays.sort(vetor);

            // impressão do vetor ordenado
            System.out.println("VETOR ORDENADO");
            for (int i = 0; i < vetor.length; i++) {
                System.out.println(i + 1 + " - " + vetor[i]);
            }

            // leitura do valor a ser buscado
            System.out.print("\nDigite o número de busca: ");
            busca = Integer.parseInt(System.console().readLine());

            // busca binária
            posicao = buscaBinaria(vetor, busca);

            // impressão do resultado
            if (posicao == -1) {
                System.out.println("\nNÃO ENCONTRADO");
            } else {
                System.out.println("\nENCONTRADO na posição " + posicao);
            }
        }

        public static int buscaBinaria(int[] vetor, int chave) {
            int inicio = 0, fim = vetor.length - 1, meio;

            while (inicio <= fim) {
                meio = (inicio + fim) / 2;
                if (vetor[meio] == chave) {
                    return meio;
                } else if (vetor[meio] < chave) {
                    inicio = meio + 1;
                } else {
                    fim = meio - 1;
                }
            }

            return -1;
        }
}