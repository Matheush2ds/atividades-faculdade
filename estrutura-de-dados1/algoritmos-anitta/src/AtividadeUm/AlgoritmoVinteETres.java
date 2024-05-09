package AtividadeUm;
//Entrar comum número inteiro de 3 casas e imprimir o algarismo da casadas dezenas.
import java.util.Scanner;

public class AlgoritmoVinteETres {
    public static void main(String[] args) {
        int a, d;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um número de tres casas: ");
        a = scan.nextInt();
        d = (a % 100) / 10;
        System.out.println(d);
    }
}
