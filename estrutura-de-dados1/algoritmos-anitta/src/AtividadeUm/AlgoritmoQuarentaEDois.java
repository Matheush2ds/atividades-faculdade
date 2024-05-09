package AtividadeUm;
/*
Entrar com um ângulo em graus e imprimir: seno, co-seno, tangente, secante,
co-secante e co-tangente deste ângulo
*/

import java.util.Scanner;

public class AlgoritmoQuarentaEDois {
    public static void main(String[] args) {
        double angulo, rang;
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com o 2 numero: ");
        angulo = scan.nextDouble();
        rang = angulo / 180 * Math.PI;

        System.out.println("Seno: " + Math.sin(rang));
        System.out.println("Cosseno: " + Math.cos(rang));
        System.out.println("Tangente: " + Math.tan(rang));
        System.out.println("Co-secante: " + 1 / Math.sin(rang));
        System.out.println("Secante: " + 1 / Math.cos(rang));
        System.out.println("Cotangente: " + 1 / Math.tan(rang));
    }
}
