package Exercicio3;

import java.util.Scanner;
public class Exercicio494 {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            String[] nome = new String[3];
            String[] ender = new String[3];
            String[] prof = new String[3];

            for (int i = 0; i < 3; i++) {
                System.out.print("Digite nome: ");
                nome[i] = scan.nextLine();
                System.out.print("Digite endereco: ");
                ender[i] = scan.nextLine();
                System.out.print("Digite profissao: ");
                prof[i] = scan.nextLine();
            }

            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (nome[i].compareTo(nome[j]) > 0) {
                        troca(nome, i, j);
                        troca(ender, i, j);
                        troca(prof, i, j);
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                System.out.println(nome[i] + "\t" + ender[i] + "\t" + prof[i]);
            }

        }

        public static void troca(String[] vetor, int i, int j) {
            String temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
        }
}