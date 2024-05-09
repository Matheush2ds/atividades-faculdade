package Exercicio3;
import java.util.Scanner;
public class Exercicio462 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nota1, nota2, nota3, media;
        System.out.print("Digite a nota da primeira prova: ");
        nota1 = scanner.nextDouble();
        System.out.print("Digite a nota da segunda prova: ");
        nota2 = scanner.nextDouble();
        System.out.print("Digite a nota da terceira prova: ");
        nota3 = scanner.nextDouble();
        media = calcularMedia(nota1, nota2, nota3);
        System.out.println("A média aritmética é " + media);
    }

    public static double calcularMedia(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3;
    }
}