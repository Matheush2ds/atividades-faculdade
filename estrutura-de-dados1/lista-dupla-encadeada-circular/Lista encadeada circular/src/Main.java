public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();
        lista.inserirEsquerda(3);
        lista.inserirEsquerda(2);
        lista.inserirEsquerda(1);

        System.out.println("Número de elementos na lista circular: " + lista.contarElementos());

        lista.inserirEsquerda(4);
        System.out.println("Número de elementos após a inserção: " + lista.contarElementos());

        ListaCircular lista2 = new ListaCircular();
        lista2.inserirEsquerda(6);
        lista2.inserirEsquerda(5);

        lista.concatenar(lista2);
        System.out.println("Número de elementos após a concatenação: " + lista.contarElementos());

        ListaCircular lista3 = new ListaCircular();
        lista3.inserirEsquerda(2);
        lista3.inserirEsquerda(1);

        ListaCircular lista4 = new ListaCircular();
        lista4.inserirEsquerda(4);
        lista4.inserirEsquerda(3);

        ListaCircular mergedList = ListaCircular.intercalarOrdenadas(lista3, lista4);
        System.out.println("Lista intercalada ordenada: ");
        imprimirLista(mergedList);

        ListaCircular copiedList = lista.copiar();
        System.out.println("Cópia da lista original: ");
        imprimirLista(copiedList);
    }

    private static void imprimirLista(ListaCircular lista) {
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
