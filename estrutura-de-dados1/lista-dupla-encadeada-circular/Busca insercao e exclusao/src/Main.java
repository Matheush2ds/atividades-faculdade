public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

        lista.inserir(1);
        lista.inserir(2);
        lista.inserir(3);

        System.out.println("Elemento 2 encontrado? " + lista.buscar(2));

        lista.excluir(2);

        System.out.println("Elemento 2 encontrado após exclusão? " + lista.buscar(2));
    }
}
