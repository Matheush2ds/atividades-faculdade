import java.util.*;

public class SorteioPilhas {
    public static void main(String[] args) {
        // Fase 1: Sortear 100 números e armazená-los nas pilhas
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int numeroSorteado = random.nextInt(9) + 1;

            if (numeroSorteado <= 3) {
                pilha1.push(numeroSorteado);
            } else if (numeroSorteado <= 6) {
                pilha2.push(numeroSorteado);
            } else {
                pilha3.push(numeroSorteado);
            }
        }

        // Exibir as pilhas após a Fase 1
        System.out.println("Exibindo pilhas após a Fase 1:");
        exibirPilhas(pilha1, pilha2, pilha3);

        // Fase 2: Realizar transferência entre as pilhas
        for (int i = 0; i < 100; i++) {
            int numeroSorteado = random.nextInt(3) + 1;
            Stack<Integer> pilhaOrigem, pilhaDestino;

            if (numeroSorteado == 1) {
                pilhaOrigem = pilha2;
                pilhaDestino = pilha1;
            } else if (numeroSorteado == 2) {
                pilhaOrigem = pilha3;
                pilhaDestino = pilha2;
            } else {
                pilhaOrigem = pilha1;
                pilhaDestino = pilha3;
            }

            if (!pilhaOrigem.isEmpty()) {
                int numeroTransferido = pilhaOrigem.pop();
                pilhaDestino.push(numeroTransferido);
                System.out.println("Empilhando o número " + numeroTransferido + " na pilha " + numeroSorteado);
            }

            if (pilha1.isEmpty() || pilha2.isEmpty() || pilha3.isEmpty()) {
                System.out.println("O programa foi encerrado porque uma das pilhas ficou vazia.");
                break;
            }

            if (i == 99) {
                System.out.println("O programa foi encerrado após 100 números sorteados.");
            }
        }

        // Exibir as pilhas após a Fase 2
        System.out.println("Exibindo pilhas após a Fase 2:");
        exibirPilhas(pilha1, pilha2, pilha3);
    }

    public static void exibirPilhas(Stack<Integer> pilha1, Stack<Integer> pilha2, Stack<Integer> pilha3) {
        int tamanhoMaximo = Math.max(Math.max(pilha1.size(), pilha2.size()), pilha3.size());

        System.out.println("Pilha 1:\tPilha 2:\tPilha 3:");
        for (int i = 0; i < tamanhoMaximo; i++) {
            if (i < pilha1.size()) {
                System.out.print(pilha1.get(pilha1.size() - i - 1) + "\t\t");
            } else {
                System.out.print("\t\t");
            }

            if (i < pilha2.size()) {
                System.out.print(pilha2.get(pilha2.size() - i - 1) + "\t\t");
            } else {
                System.out.print("\t\t");
            }

            if (i < pilha3.size()) {
                System.out.print(pilha3.get(pilha3.size() - i - 1));
            }
            System.out.println();
        }
        System.out.println();
    }
}
