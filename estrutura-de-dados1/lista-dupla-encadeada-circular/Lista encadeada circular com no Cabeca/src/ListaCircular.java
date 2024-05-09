public class ListaCircular {
    private Node head;

    public ListaCircular() {
        this.head = new Node(0); // "Nó cabeça" com valor 0
        this.head.next = this.head; // Aponta para si mesmo
    }

    // Método para verificar se a lista está vazia
    public boolean isEmpty() {
        return head.next == head;
    }

    // Método para inserir um elemento no final da lista
    public void inserir(int elemento) {
        Node newNode = new Node(elemento);

        if (isEmpty()) {
            head.next = newNode;
        } else {
            Node current = head.next;

            while (current.next != head) {
                current = current.next;
            }

            current.next = newNode;
        }
        newNode.next = head;
    }

    // Método para remover um elemento da lista
    public boolean remover(int elemento) {
        if (isEmpty()) {
            return false;
        }

        Node previous = head;
        Node current = head.next;

        while (current != head) {
            if (current.data == elemento) {
                previous.next = current.next;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    // Método para exibir os elementos da lista
    public void exibir() {
        if (isEmpty()) {
            System.out.println("A lista está vazia.");
            return;
        }

        Node current = head.next;

        while (current != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}