import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GerenciadorContato {
    private ArvoreAvl contactsTree;
    private List<Contato> contactList;

    public GerenciadorContato() {
        contactsTree = ArvoreAvl.loadFromFile("contacts.dat");
        if (contactsTree == null) {
            contactsTree = new ArvoreAvl();
        }

        contactList = new ArrayList<>();
    }

    public void addContact(String name, String phoneNumber) {
        contactsTree.insert(name, phoneNumber);
        contactList.add(new Contato(name, phoneNumber));
    }

    public boolean searchContact(String name) {
        return searchContactInList(name) || searchContactInTree(name);
    }

    private boolean searchContactInList(String name) {
        for (Contato contato : contactList) {
            if (contato.nome.equalsIgnoreCase(name)) {
                System.out.println("Contato encontrado na lista: " + contato);
                return true;
            }
        }
        return false;
    }

    private boolean searchContactInTree(String name) {
        return searchContactInTree(contactsTree.getRoot(), name);
    }

    private boolean searchContactInTree(ArvoreAvl.Node node, String name) {
        if (node == null) {
            return false;
        }

        int compareResult = name.compareToIgnoreCase(node.data.nome);

        if (compareResult == 0) {
            System.out.println("Contato encontrado na árvore AVL: " + node.data);
            return true;
        } else if (compareResult < 0) {
            return searchContactInTree(node.esquerda, name);
        } else {
            return searchContactInTree(node.direita, name);
        }
    }

    public String displayContacts() {
        contactsTree.inOrderTraversal();
        return "";
    }

    public void mergeSortContacts() {
        contactList = mergeSort(contactList);
        contactsTree = buildAVLTreeFromList(contactList);
        System.out.println("Contatos ordenados com Merge Sort!");
    }

    public void quickSortContacts() {
        Collections.sort(contactList);
        contactsTree = buildAVLTreeFromList(contactList);
        System.out.println("Contatos ordenados com Quick Sort!");
    }

    private List<Contato> mergeSort(List<Contato> contacts) {
        if (contacts.size() <= 1) {
            return contacts;
        }

        int meio = contacts.size() / 2;
        List<Contato> parteEsquerda = mergeSort(contacts.subList(0, meio));
        List<Contato> parteDireita = mergeSort(contacts.subList(meio, contacts.size()));

        return merge(parteEsquerda, parteDireita);
    }

    private List<Contato> merge(List<Contato> parteEsquerda, List<Contato> parteDireita) {
        List<Contato> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < parteEsquerda.size() && j < parteDireita.size()) {
            if (parteEsquerda.get(i).compareTo(parteDireita.get(j)) < 0) {
                result.add(parteEsquerda.get(i++));
            } else {
                result.add(parteDireita.get(j++));
            }
        }

        result.addAll(parteEsquerda.subList(i, parteEsquerda.size()));
        result.addAll(parteDireita.subList(j, parteDireita.size()));

        return result;
    }

    private ArvoreAvl buildAVLTreeFromList(List<Contato> contacts) {
        ArvoreAvl avlTree = new ArvoreAvl();
        for (Contato contato : contacts) {
            avlTree.insert(contato.nome, contato.numeroDeTelefone);
        }
        return avlTree;
    }

    public void saveContacts() {
        contactsTree.saveToFile("contacts.dat");
        System.out.println("Contatos salvos com sucesso!");
    }
}
