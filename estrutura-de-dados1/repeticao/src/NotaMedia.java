import java.util.Scanner;

public class NotaMedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nomes = new String[5];
        double[] nota1 = new double[5];
        double[] nota2 = new double[5];
        double[] medias = new double[5];

        // entrada de dados
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome do aluno " + (i+1) + ": ");
            nomes[i] = scan.nextLine();

            System.out.print("Digite a primeira nota do aluno " + (i+1) + ": ");
            nota1[i] = Double.parseDouble(scan.nextLine());

            System.out.print("Digite a segunda nota do aluno " + (i+1) + ": ");
            nota2[i] = Double.parseDouble(scan.nextLine());

            medias[i] = (nota1[i] + nota2[i]) / 2;
        }

        // saída de dados
        System.out.println("\n\n\t\t\t\tRELACAO FINAL\n");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d - %s\n%.2f\t%.2f\t%.2f\n\n", i+1, nomes[i], nota1[i], nota2[i], medias[i]);
        }
    }
}