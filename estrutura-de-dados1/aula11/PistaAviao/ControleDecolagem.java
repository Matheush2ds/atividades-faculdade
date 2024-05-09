package PistaAviao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ControleDecolagem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Aviao> filaDecolagem = new LinkedList<>();

        while (true) {
            System.out.println("==== CONTROLE DE PISTA DE DECOLAGEM ====");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar número de aviões aguardando na fila de decolagem");
            System.out.println("2 - Autorizar decolagem do primeiro avião da fila");
            System.out.println("3 - Adicionar um avião à fila de espera");
            System.out.println("4 - Listar todos os aviões na fila de espera");
            System.out.println("5 - Listar características do primeiro avião da fila");
            System.out.println("0 - Encerrar programa");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Número de aviões aguardando na fila de decolagem: " + filaDecolagem.size());
                    break;
                case 2:
                    if (filaDecolagem.isEmpty()) {
                        System.out.println("Não há aviões aguardando na fila de decolagem.");
                    } else {
                        Aviao aviao = filaDecolagem.remove();
                        System.out.println("Avião " + aviao.getNumero() + " autorizado para decolagem.");
                    }
                    break;
                case 3:
                    scanner.nextLine(); // consumir o caractere de quebra de linha pendente
                    System.out.print("Digite o nome do avião: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o número do avião: ");
                    int numero = scanner.nextInt();
                    Aviao novoAviao = new Aviao(nome, numero);
                    filaDecolagem.add(novoAviao);
                    System.out.println("Avião " + novoAviao.getNome() + " adicionado à fila de espera.");
                    break;
                case 4:
                    System.out.println("Aviões na fila de espera:");
                    for (Aviao av : filaDecolagem) {
                        System.out.println(av);
                    }
                    break;
                case 5:
                    if (filaDecolagem.isEmpty()) {
                        System.out.println("Não há aviões aguardando na fila de decolagem.");
                    } else {
                        Aviao aviao = filaDecolagem.peek();
                        System.out.println("Características do primeiro avião na fila:");
                        System.out.println("Nome: " + aviao.getNome());
                        System.out.println("Número: " + aviao.getNumero());
                    }
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            System.out.println();
        }
    }
}