public class ListaDuplamenteEncadeada {
    private Node head;
    private Node tail;

    public ListaDuplamenteEncadeada() {
        head = new Node(-1); // Valor fictício
        tail = head;
    }

    public boolean buscar(int elemento) {
        Node current = head.next;

        while (current != null) {
            if (current.data == elemento) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    public void inserir(int elemento) {
        Node newNode = new Node(elemento);

        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
    }

    public void excluir(int elemento) {
        Node current = head.next;

        while (current != null) {
            if (current.data == elemento) {
                Node previousNode = current.previous;
                Node nextNode = current.next;

                previousNode.next = nextNode;

                if (nextNode != null) {
                    nextNode.previous = previousNode;
                } else {
                    tail = previousNode;
                }

                return;
            }

            current = current.next;
        }
    }
}
