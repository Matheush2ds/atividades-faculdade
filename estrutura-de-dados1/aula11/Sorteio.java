import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Sorteio {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        Stack<Integer> pilha = new Stack<>();

        for (int i = 0; i < 1000; i++) {
            fila.offer((int) (Math.random() * 1000));
            fila.offer((int) (Math.random() * -1000));
        }

        while (!fila.isEmpty()) {
            int valor = fila.poll();

            if (valor >= 0) {
                pilha.push(valor);
            } else {
                if (!pilha.isEmpty()) {
                    int topo = pilha.pop();
                    System.out.println("Número retirado da pilha: " + topo);
                }
            }
        }

        System.out.println("Fila final: " + fila);
        System.out.println("Pilha final: " + pilha);
    }
}
