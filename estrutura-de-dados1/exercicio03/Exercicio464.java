package Exercicio3;

import java.util.Scanner;
public class Exercicio464 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double angulo, graus;

            System.out.print("Digite o ângulo em radianos: ");
            angulo = scanner.nextDouble();
            graus = radianosParaGraus(angulo);
            System.out.println("Ângulo em radianos: " + angulo + ", Ângulo em graus: " + graus);
        }

        public static double radianosParaGraus(double anguloRadianos) {
            double anguloGraus = anguloRadianos * 180.0 / Math.PI;
            return anguloGraus;
        }
 }