import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class No {
    int valor;
    No esquerda, direita;

    public No(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

class ArvoreBinaria {
    No raiz;

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRec(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRec(no.direita, valor);
        }

        return no;
    }

    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public void inOrdem(No no) {
        if (no != null) {
            inOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            inOrdem(no.direita);
        }
    }

    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public void emNivel() {
        if (raiz == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No no = fila.poll();
            System.out.print(no.valor + " ");

            if (no.esquerda != null) {
                fila.add(no.esquerda);
            }

            if (no.direita != null) {
                fila.add(no.direita);
            }
        }
    }

    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No no, int valor) {
        if (no == null) {
            return no;
        }

        if (valor < no.valor) {
            no.esquerda = removerRec(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = removerRec(no.direita, valor);
        } else {

            if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            }

            no.valor = menorValor(no.direita);

            no.direita = removerRec(no.direita, no.valor);
        }

        return no;
    }

    private int menorValor(No no) {
        int menorValor = no.valor;
        while (no.esquerda != null) {
            menorValor = no.esquerda.valor;
            no = no.esquerda;
        }
        return menorValor;
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random random = new Random();

        System.out.println("Inserindo 20 números aleatórios na árvore:");
        for (int i = 0; i < 20; i++) {
            int numero = random.nextInt(101);
            arvore.inserir(numero);
            System.out.print(numero + " ");
        }

        System.out.println("\n\nImpressão em pré-ordem:");
        arvore.preOrdem(arvore.raiz);

        System.out.println("\n\nImpressão em ordem:");
        arvore.inOrdem(arvore.raiz);

        System.out.println("\n\nImpressão em pós-ordem:");
        arvore.posOrdem(arvore.raiz);

        System.out.println("\n\nImpressão em nível:");
        arvore.emNivel();

        for (int i = 0; i < 5; i++) {
            int numeroRemover = random.nextInt(101);
            System.out.println("\n\nRemovendo o número " + numeroRemover);
            arvore.remover(numeroRemover);

            System.out.println("Impressão em pré-ordem após remoção:");
            arvore.preOrdem(arvore.raiz);

            System.out.println("\nImpressão em in-ordem após remoção:");
            arvore.inOrdem(arvore.raiz);

            System.out.println("\nImpressão em pós-ordem após remoção:");
            arvore.posOrdem(arvore.raiz);

            System.out.println("\nImpressão em nível após remoção:");
            arvore.emNivel();
        }
    }
}
