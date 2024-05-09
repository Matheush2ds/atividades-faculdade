public class ListaDuplamenteEncadeada {
    private Node head;
    private Node tail;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
    }

    // Método para concatenar duas listas
    public void concatenate(ListaDuplamenteEncadeada list) {
        if (this.head == null) {
            this.head = list.head;
        } else if (list.head != null) {
            this.tail.next = list.head;
            list.head.previous = this.tail;
        }

        if (list.tail != null) {
            this.tail = list.tail;
        }
    }

    // Método que separa uma lista em duas novas listas
    public ListaDuplamenteEncadeada[] split() {
        ListaDuplamenteEncadeada[] lists = new ListaDuplamenteEncadeada[2];
        lists[0] = new ListaDuplamenteEncadeada();
        lists[1] = new ListaDuplamenteEncadeada();

        if (this.head == null) {
            return lists;
        }

        Node slow = this.head;
        Node fast = this.head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        lists[0].head = this.head;
        lists[0].tail = slow;
        lists[1].head = slow.next;
        lists[1].tail = this.tail;

        if (slow != null) {
            slow.next = null;
        }

        return lists;
    }

    // Método para intercalar duas listas ordenadas em uma lista ordenada
    public static ListaDuplamenteEncadeada mergeSortedLists(ListaDuplamenteEncadeada list1, ListaDuplamenteEncadeada list2) {
        ListaDuplamenteEncadeada mergedList = new ListaDuplamenteEncadeada();

        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.append(current1.data);
                current1 = current1.next;
            } else {
                mergedList.append(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.append(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.append(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }

    // Método auxiliar para adicionar um elemento ao final da lista
    public void append(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.previous = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
}
