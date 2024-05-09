public class Main {
    public static void main(String[] args) {
        ListaCircularDuplamenteEncadeada lista = new ListaCircularDuplamenteEncadeada();
        lista.inserirEsquerda(3);
        lista.inserirEsquerda(2);
        lista.inserirEsquerda(1);

        System.out.println("Número de elementos na lista circular duplamente encadeada: " + lista.contarElementos());

        lista.inserirEsquerda(4);
        System.out.println("Número de elementos após a inserção: " + lista.contarElementos());

        ListaCircularDuplamenteEncadeada lista2 = new ListaCircularDuplamenteEncadeada();
        lista2.inserirEsquerda(6);
        lista2.inserirEsquerda(5);

        lista.concatenar(lista2);
        System.out.println("Número de elementos após a concatenação: " + lista.contarElementos());

        ListaCircularDuplamenteEncadeada lista3 = new ListaCircularDuplamenteEncadeada();
        lista3.inserirEsquerda(2);
        lista3.inserirEsquerda(1);

        ListaCircularDuplamenteEncadeada lista4 = new ListaCircularDuplamenteEncadeada();
        lista4.inserirEsquerda(4);
        lista4.inserirEsquerda(3);

        ListaCircularDuplamenteEncadeada mergedList = ListaCircularDuplamenteEncadeada.intercalarOrdenadas(lista3, lista4);
        System.out.println("Lista intercalada ordenada: ");
        imprimirLista(mergedList);

        ListaCircularDuplamenteEncadeada copiedList = lista.copiar();
        System.out.println("Cópia da lista original: ");
        imprimirLista(copiedList);
    }

    private static void imprimirLista(ListaCircularDuplamenteEncadeada lista) {
        if (lista == null || lista.head == null) {
            return;
        }

        Node current = lista.head.next;

        while (current != lista.head) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}
