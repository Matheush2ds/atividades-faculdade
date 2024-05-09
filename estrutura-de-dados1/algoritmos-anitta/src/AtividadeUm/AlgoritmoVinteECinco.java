package AtividadeUm;
//Entrar com uma data no formato ddmmaa e imprimir: dia, mês e ano separados.
import java.util.Scanner;

public class AlgoritmoVinteECinco {
    public static void main(String[] args) {
        int data, dia, mes, ano;

        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a data no formato ddmmaa: ");
        data = scan.nextInt();

        dia = data / 10000;
        mes = (data % 10000) / 100;
        ano = data % 100;

        System.out.println("Dia: " + dia);
        System.out.println("Mês: " + mes);
        System.out.println("Ano: " + ano);

    }
}