import java.util.Scanner;
import java.util.Stack;

public class RemoveItemPilha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma sequência de números separados por espaço: ");
        String input = scanner.nextLine();
        String[] numerosString = input.split(" ");
        Stack<Integer> pilha = new Stack<>();
        for (String numero : numerosString) {
            pilha.push(Integer.parseInt(numero));
        }
        System.out.print("Digite o número que deseja remover da pilha: ");
        int c = scanner.nextInt();
        removerItemPilha(pilha, c);
        System.out.println("Pilha atualizada: " + pilha);
    }

    public static void removerItemPilha(Stack<Integer> pilha, int c) {
        Stack<Integer> aux = new Stack<>();
        while (!pilha.isEmpty()) {
            int elemento = pilha.pop();
            if (elemento != c) {
                aux.push(elemento);
            } else {
                break;
            }
        }
        while (!aux.isEmpty()) {
            pilha.push(aux.pop());
        }
    }
}