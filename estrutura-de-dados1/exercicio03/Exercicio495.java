package Exercicio3;
import java.util.Arrays;
public class Exercicio495 {

        public static void main(String[] args) {
            String[] nomes = new String[5];

            for(int i = 0; i < 5; i++) {
                System.out.print("Digite nome " + (i+1) + ": ");
                nomes[i] = System.console().readLine();
            }

            ordena(nomes);

            System.out.println("\n\nNOMES ORDENADOS");
            for(int i = 0; i < 5; i++) {
                System.out.println((i+1) + " - " + nomes[i]);
            }
        }

        public static void ordena(String[] vetor) {
            Arrays.sort(vetor);
        }
}