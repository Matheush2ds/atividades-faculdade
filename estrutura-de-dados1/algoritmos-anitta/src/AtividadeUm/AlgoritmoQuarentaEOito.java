package AtividadeUm;
/*
Antes de o racionamento de energia ser decretado, quase ninguém falava em
quilowatts; mas, agora, todos incorporaram essa palavra em seu vocabulário. Sabendo-se que 100 quilowatts de
energia custa um sétimo do salário mínimo, fazer um algoritmo que receba o valor do salário mínimo e a quantidade
de quilowatts gasta por uma residência e calcule. Imprima:

o valor em reais de cada quilowatt
m o valor em reais a ser pago
o novo valor a ser pago por essa residência com um desconto de 10%.
*/

import java.util.Scanner;

public class AlgoritmoQuarentaEOito {
    public static void main(String[] args) {
        double sm, qtdade, preco, vp, vd;
        Scanner scan = new Scanner(System.in);

        System.out.print("\nEntre com o salário mínimo: ");
        sm = scan.nextDouble();
        System.out.print("\nEntre com a quantidade em quilowatt: ");
        qtdade = scan.nextDouble();

        // Divide por 7 para achar o preço de 100 Kw e por 100 para achar de 1 Kw
        preco = sm / 700.0;
        vp = preco * qtdade;
        vd = vp * 0.9;

        System.out.println("\nPreço do quilowatt: " + preco + "\nValor a ser pago: " + vp
                + "\nValor com desconto: " + vd);
        System.out.println();
        scan.close();
    }
}