package AtividadeUm;
/*
Entrar com dois numeros inteiros e imprimir a seguinte saída:
dividendo
divisor:
quociente:
resto:
*/

import java.util.Scanner;

public class AlgoritmoQuarenta {
    public static void main(String[] args) {
        int quociente, resto, valor1, valor2;
        Scanner scan = new Scanner(System.in);

        System.out.println("Entre com o dividendo: ");
        valor1 = scan.nextInt();
        System.out.println("Entre com o divisor: ");
        valor2 = scan.nextInt();

        quociente = (valor1 / valor2);
        resto = (valor1 % valor2);

        System.out.println("Dividendo: " + valor1);
        System.out.println("Divisor: " + valor2);
        System.out.println("Quociente: " + quociente);
        System.out.println("Resto: " + resto);

    }
}
