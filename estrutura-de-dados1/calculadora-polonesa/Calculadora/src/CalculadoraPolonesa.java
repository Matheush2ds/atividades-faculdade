import java.util.Stack;
import java.util.Scanner;

public class CalculadoraPolonesa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a expressão desejada: ");
        String expressao = scanner.nextLine();

        double resultado = calcular(expressao);

        System.out.println("Resultado: " + resultado);

        System.out.println("Posfixa: " + expressao);
        System.out.println("Infixa: " + converterParaInfixa(expressao));
        System.out.println("Prefixa: " + converterParaPrefixa(expressao));
    }

    public static double calcular(String expressao) {
        Stack<Double> pilhas = new Stack<>();

        String[] elementos = expressao.split(" ");

        for (String elemento : elementos) {
            if (elemento.matches("\\d+(\\.\\d+)?")) {
                pilhas.push(Double.parseDouble(elemento));
            } else {
                double operando2 = pilhas.pop();
                double operando1 = pilhas.pop();

                double resultado = switch (elemento) {
                    case "+" -> operando1 + operando2;
                    case "-" -> operando1 - operando2;
                    case "*" -> operando1 * operando2;
                    case "/" -> operando1 / operando2;
                    default -> 0.0;
                };

                pilhas.push(resultado);
            }
        }

        return pilhas.pop();
    }

    public static String converterParaInfixa(String expressao) {
        Stack<String> pilhas = new Stack<>();

        String[] elementos = expressao.split(" ");

        for (String elemento : elementos) {
            if (elemento.matches("\\d+(\\.\\d+)?")) {
                pilhas.push(elemento);
            } else {
                String operando2 = pilhas.pop();
                String operando1 = pilhas.pop();

                String resultado = "(" + operando1 + " " + elemento + " " + operando2 + ")";

                pilhas.push(resultado);
            }
        }

        return pilhas.pop();
    }

    public static String converterParaPrefixa(String expressao) {
        Stack<String> pilhas = new Stack<>();

        String[] elementos = expressao.split(" ");

        for (int a = elementos.length - 1; a >= 0; a--) {
            String elemento = elementos[a];

            if (elemento.matches("\\d+(\\.\\d+)?")) {
                pilhas.push(elemento);
            } else {
                String operando1 = pilhas.pop();
                String operando2 = pilhas.pop();

                String resultado = elemento + " " + operando2 + " " + operando1;

                pilhas.push(resultado);
            }
        }

        return pilhas.pop();
    }
}
