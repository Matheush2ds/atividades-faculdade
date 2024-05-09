//358
import java.util.Scanner;

public class LucroMercadoria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int NUM_MERCADORIAS = 100;
        double precoCompra;
        double precoVenda;
        double lucro;

        int numLucroMenor10 = 0;
        int numLucroEntre10E20 = 0;
        int numLucroMaior20 = 0;

        for (int i = 1; i <= NUM_MERCADORIAS; i++) {
            System.out.printf("Digite o preço de compra da mercadoria %d: ", i);
            precoCompra = scan.nextDouble();

            System.out.printf("Digite o preço de venda da mercadoria %d: ", i);
            precoVenda = scan.nextDouble();

            lucro = ((precoVenda - precoCompra) / precoCompra) * 100;

            if (lucro < 10) {
                numLucroMenor10++;
            } else if (lucro <= 20) {
                numLucroEntre10E20++;
            } else {
                numLucroMaior20++;
            }
        }

        System.out.printf("%d mercadorias proporcionam lucro menor que 10%%\n", numLucroMenor10);
        System.out.printf("%d mercadorias proporcionam lucro entre 10%% e 20%%\n", numLucroEntre10E20);
        System.out.printf("%d mercadorias proporcionam lucro maior que 20%%\n", numLucroMaior20);

    }
}