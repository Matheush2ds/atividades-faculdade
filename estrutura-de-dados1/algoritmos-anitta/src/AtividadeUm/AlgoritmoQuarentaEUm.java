package AtividadeUm;

//Entrar com quatro números e imprimir a média ponderada, sabendo-se que os
//pesos são respectivamente: 1, 2, 3 e 4.

import java.util.Scanner;

public class AlgoritmoQuarentaEUm {
    public static void main(String[] args) {
        double a, b, c, d, media;
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com o 1 numero: ");
        a = scan.nextInt();
        System.out.println("Entre com o 2 numero: ");
        b = scan.nextInt();
        System.out.println("Entre com o 3 numero: ");
        c = scan.nextInt();
        System.out.println("Entre com o 4 numero: ");
        d = scan.nextInt();

        media = (a *1 + b *2 + c *3 + d *4) / 10;
        System.out.println("Media ponderada: " + media);

    }
}
