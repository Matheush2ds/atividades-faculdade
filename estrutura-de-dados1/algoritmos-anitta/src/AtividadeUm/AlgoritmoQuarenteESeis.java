package AtividadeUm;
/*
Fazer um algoritmo que possa entrar com o saldo de uma aplicação e imprima o
novo saldo, considerando o reajuste de 1%.
*/

import java.util.Scanner;

public class AlgoritmoQuarenteESeis {
    public static void main(String[] args) {
        double saldo, nsaldo;
        Scanner scan = new Scanner(System.in);

        System.out.print("Digite saldo: ");
        saldo = scan.nextDouble();
        nsaldo = saldo * 1.01;

        System.out.println("\nNovo saldo: " + nsaldo);
    }
}