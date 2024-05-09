import java.util.*;

public class FilaEPilha {

    public static void main(String[] args) {
        Random rand = new Random();
        Queue<Integer> fila = new LinkedList<>();
        Stack<Integer> pilha = new Stack<>();

        for (int i = 0; i < 1000; i++) {
            int num = rand.nextInt(1000);
            if (!fila.contains(num)) {
                fila.offer(num);
            } else {
                pilha.push(num);
            }
        }

        System.out.println("Fila F: " + fila);
        System.out.println("Pilha P: " + pilha);
    }

}