public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada list1 = new ListaDuplamenteEncadeada();
        list1.append(1);
        list1.append(3);
        list1.append(5);

        ListaDuplamenteEncadeada list2 = new ListaDuplamenteEncadeada();
        list2.append(2);
        list2.append(4);
        list2.append(6);

        list1.concatenate(list2);
        System.out.println("Lista concatenada: " + list1.toString());

        ListaDuplamenteEncadeada[] lists = list1.split();
        System.out.println("Lista 1 após separação: " + lists[0].toString());
        System.out.println("Lista 2 após separação: " + lists[1].toString());

        ListaDuplamenteEncadeada list3 = new ListaDuplamenteEncadeada();
        list3.append(2);
        list3.append(4);
        list3.append(6);

        ListaDuplamenteEncadeada list4 = new ListaDuplamenteEncadeada();
        list4.append(1);
        list4.append(3);
        list4.append(5);

        ListaDuplamenteEncadeada mergedList = ListaDuplamenteEncadeada.mergeSortedLists(list3, list4);
        System.out.println("Lista ordenada resultante: " + mergedList.toString());
    }
}
