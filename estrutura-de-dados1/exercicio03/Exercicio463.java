package Exercicio3;

import java.util.Scanner;
public class Exercicio463 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double angulo, radiano;
        System.out.print("Digite o ângulo em graus: ");
        angulo = scanner.nextDouble();
        radiano = grausParaRadianos(angulo);
        System.out.println("Ângulo em graus: " + angulo + ", Ângulo em radianos: " + radiano);
    }

    public static double grausParaRadianos(double anguloGraus) {
        double anguloRadianos = anguloGraus * Math.PI / 180.0;
        return anguloRadianos;
    }
}