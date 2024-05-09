package AtividadeUm;
//Entrar com uma data no formato ddmmaa e imprimir no formato mmddaa.

import java.util.Scanner;

public class AlgoritmoVinteESeis {
        public static void main(String[] args) {
            int data, dia, mes, ano, ndata;

            Scanner scan = new Scanner(System.in);
            System.out.println("Digite a data no formato ddmmaa: ");
            data = scan.nextInt();

            dia = data / 10000;
            mes = (data % 10000) / 100;
            ano = data % 100;
            ndata = (mes * 10000) + (dia * 100) + ano;

            System.out.println("Dia: " + dia);
            System.out.println("Mês: " + mes);
            System.out.println("Ano: " + ano);
            System.out.println("Data no formato MMDDAA: " + ndata);

        }
    }