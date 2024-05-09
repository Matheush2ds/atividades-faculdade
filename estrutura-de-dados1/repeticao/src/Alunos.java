//356
import java.util.Scanner;

public class Alunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nomes = new String[10];
        double[] pr1 = new double[10];
        double[] pr2 = new double[10];
        int[] media = new int[10];
        String[] situacao = new String[10];

        // Entrada de dados
        for (int i = 0; i < 10; i++) {
            System.out.printf("Digite o nome do aluno %d: ", i+1);
            nomes[i] = scanner.nextLine();

            System.out.printf("Digite a nota da PR1 do aluno %d: ", i+1);
            pr1[i] = scanner.nextDouble();

            System.out.printf("Digite a nota da PR2 do aluno %d: ", i+1);
            pr2[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpa o buffer do scanner

            // Cálculo da média
            media[i] = (int) Math.round((pr1[i] + pr2[i]) / 2.0);

            // Definição da situação
            if (media[i] >= 5) {
                situacao[i] = "AP";
            } else {
                situacao[i] = "RP";
            }
        }

        // Saída de dados
        System.out.println("\n\nRELATÓRIO FINAL\n");
        System.out.println("Nome\t\tPR1\tPR2\tMédia\tSituação");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\t\t%.1f\t%.1f\t%d\t%s\n", nomes[i], pr1[i], pr2[i], media[i], situacao[i]);
        }
    }
}
