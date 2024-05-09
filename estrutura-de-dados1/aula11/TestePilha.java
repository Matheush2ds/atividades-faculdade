import java.util.*;

public class TestePilha {
    public static void main(String[] args) {
        Stack<Integer> P = new Stack<>(); // Pilha para números positivos
        Stack<Integer> N = new Stack<>(); // Pilha para números negativos
        Random random = new Random();

        // Sorteia 1000 números entre -100 e 100
        for (int i = 0; i < 1000; i++) {
            int numero = random.nextInt(201) - 100;
            if (numero > 0) {
                P.push(numero);
            } else if (numero < 0) {
                N.push(numero);
            } else {
                if (!P.isEmpty() && !N.isEmpty()) {
                    System.out.println("Número retirado da pilha de positivos: " + P.pop());
                    System.out.println("Número retirado da pilha de negativos: " + N.pop());
                }
            }
        }
    }
}
