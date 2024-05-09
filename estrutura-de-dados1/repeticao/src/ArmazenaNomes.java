import java.util.Scanner;

public class ArmazenaNomes {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nomes = new String[5];

        // Armazena os nomes no vetor
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome " + (i+1) + ": ");
            nomes[i] = scan.nextLine();
        }

        // Pede o número da pessoa a ser impressa
        System.out.print("Digite o número da pessoa a ser impressa (1 a 5): ");
        int num = scan.nextInt();

        // Imprime o nome correspondente
        System.out.println("Nome da pessoa " + num + ": " + nomes[num-1]);

    }
}