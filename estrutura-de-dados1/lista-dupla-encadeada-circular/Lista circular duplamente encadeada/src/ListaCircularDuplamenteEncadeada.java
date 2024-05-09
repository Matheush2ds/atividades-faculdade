public class ListaCircularDuplamenteEncadeada {
    Node head;

    public ListaCircularDuplamenteEncadeada() {
        this.head = null;
    }

    public int contarElementos() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        Node current = head.next;

        while (current != head) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void inserirEsquerda(int elemento) {
        Node newNode = new Node(elemento);

        if (head == null) {
            newNode.previous = newNode;
            newNode.next = newNode;
            head = newNode;
        } else {
            newNode.next = head;
            newNode.previous = head.previous;
            head.previous.next = newNode;
            head.previous = newNode;
        }
    }

    public void concatenar(ListaCircularDuplamenteEncadeada lista) {
        if (this.head == null) {
            this.head = lista.head;
        } else if (lista.head != null) {
            Node temp = this.head.next;
            this.head.next = lista.head;
            lista.head.previous.next = temp;
            temp.previous = lista.head.previous;
            lista.head.previous = this.head.previous;
            this.head.previous = lista.head;
        }
    }

    public static ListaCircularDuplamenteEncadeada intercalarOrdenadas(ListaCircularDuplamenteEncadeada lista1,
                                                                       ListaCircularDuplamenteEncadeada lista2) {
        ListaCircularDuplamenteEncadeada mergedList = new ListaCircularDuplamenteEncadeada();

        Node current1 = lista1.head;
        Node current2 = lista2.head;

        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.inserirEsquerda(current1.data);
                current1 = current1.next;
            } else {
                mergedList.inserirEsquerda(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.inserirEsquerda(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.inserirEsquerda(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    public ListaCircularDuplamenteEncadeada copiar() {
        ListaCircularDuplamenteEncadeada copiedList = new ListaCircularDuplamenteEncadeada();

        if (this.head == null) {
            return copiedList;
        }

        Node current = this.head.next;

        while (current != this.head) {
            copiedList.inserirEsquerda(current.data);
            current = current.next;
        }

        copiedList.inserirEsquerda(this.head.data);

        return copiedList;
    }
}