import java.util.*;

public class InverterFilaComPilha {

    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            fila.add(i);
        }
        System.out.println("Fila original: " + fila);
        inverterFilaComPilha(fila);
        System.out.println("Fila invertida: " + fila);
    }

    public static void inverterFilaComPilha(Queue<Integer> fila) {
        Stack<Integer> pilha = new Stack<>();
        while (!fila.isEmpty()) {
            pilha.push(fila.poll());
        }
        while (!pilha.isEmpty()) {
            fila.add(pilha.pop());
        }
    }
}
