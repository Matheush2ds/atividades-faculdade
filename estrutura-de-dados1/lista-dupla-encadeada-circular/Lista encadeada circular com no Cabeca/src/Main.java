public class Main {
    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);

        System.out.println("Elementos da lista:");
        lista.exibir();

        boolean removido = lista.remover(2);

        if (removido) {
            System.out.println("Elemento removido com sucesso.");
        } else {
            System.out.println("Elemento não encontrado.");
        }

        System.out.println("Elementos da lista após a remoção:");
        lista.exibir();
    }
}
