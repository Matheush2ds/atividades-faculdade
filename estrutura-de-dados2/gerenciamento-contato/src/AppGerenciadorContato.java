import javax.swing.*;

public class AppGerenciadorContato {
    public static void main(String[] args) {
        GerenciadorContato contactManager = new GerenciadorContato();

        while (true) {
            String[] options = {"Adicionar Contato", "Buscar Contato", "Exibir Contatos", "Ordenar Contatos", "Salvar e Sair"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Gerenciador de Contatos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0:
                    String name = JOptionPane.showInputDialog("Nome:");
                    String phoneNumber = JOptionPane.showInputDialog("Número de Telefone:");
                    contactManager.addContact(name, phoneNumber);
                    break;

                case 1:
                    String searchName = JOptionPane.showInputDialog("Nome para Busca:");
                    boolean found = contactManager.searchContact(searchName);
                    JOptionPane.showMessageDialog(null, "Contato encontrado: " + (found ? "Sim" : "Não"));
                    break;

                case 2:
                    contactManager.displayContacts();
                    break;

                case 3:
                    contactManager.quickSortContacts();
                    JOptionPane.showMessageDialog(null, "Contatos ordenados com sucesso!");
                    break;

                case 4:
                    contactManager.saveContacts();
                    JOptionPane.showMessageDialog(null, "Contatos salvos com sucesso!");
                    System.exit(0);

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        }
    }
}
