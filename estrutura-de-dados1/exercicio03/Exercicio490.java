package Exercicio3;

import java.util.Scanner;

public class Exercicio490 {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            // Leitura do vetor de palavras
            String[] palavras = new String[10];
            for (int i = 0; i < 10; i++) {
                System.out.print("Digite a palavra " + (i+1) + ": ");
                palavras[i] = scan.nextLine();
            }

            // Leitura do caractere a ser retirado
            System.out.print("Digite o caractere a ser retirado: ");
            char caractere = scan.nextLine().charAt(0);

            // Processamento das palavras
            for (int i = 0; i < palavras.length; i++) {
                int totalRetirado = retirarCaractere(palavras[i], caractere);
                System.out.println((i+1) + " - " + palavras[i]);
            }
        }

        public static int retirarCaractere(String palavra, char caractere) {
            int totalRetirado = 0;
            char[] caracteres = palavra.toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                if (caracteres[i] == caractere) {
                    caracteres[i] = '*';
                    totalRetirado++;
                }
            }
            palavra = new String(caracteres);
            return totalRetirado;
        }
}