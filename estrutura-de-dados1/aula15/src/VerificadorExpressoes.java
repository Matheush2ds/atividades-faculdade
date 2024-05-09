import java.util.Scanner;
import java.util.Stack;

public class VerificadorExpressoes {

    public static boolean verificaExpressao(String expressao) {
        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '(' || caractere == '[' || caractere == '{') {
                pilha.push(caractere);
            } else if (caractere == ')' || caractere == ']' || caractere == '}') {
                if (pilha.isEmpty()) {
                    return false; // Encontrou um fecha parênteses sem o correspondente abre parênteses
                }

                char topo = pilha.pop();
                if ((caractere == ')' && topo != '(') ||
                        (caractere == ']' && topo != '[') ||
                        (caractere == '}' && topo != '{')) {
                    return false; // Parênteses/colchete/chave não correspondentes
                }
            }
        }

        return pilha.isEmpty(); // Verifica se não sobraram parênteses/colchetes/chaves abertos
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma expressão matemática: ");
        String expressao = scanner.nextLine();

        if (verificaExpressao(expressao)) {
            System.out.println("A expressão está correta!");
        } else {
            System.out.println("A expressão está incorreta!");
        }
    }
}
