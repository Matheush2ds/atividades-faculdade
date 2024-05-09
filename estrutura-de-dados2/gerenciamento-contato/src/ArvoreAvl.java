import java.io.*;

public class ArvoreAvl implements Serializable {
    private Node root;

    int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    int balanceFactor(Node node) {
        if (node == null) return 0;
        return height(node.esquerda) - height(node.direita);
    }

    Node rightRotate(Node y) {
        Node x = y.esquerda;
        Node T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.height = Math.max(height(y.esquerda), height(y.direita)) + 1;
        x.height = Math.max(height(x.esquerda), height(x.direita)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.direita;
        Node T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.height = Math.max(height(x.esquerda), height(x.direita)) + 1;
        y.height = Math.max(height(y.esquerda), height(y.direita)) + 1;

        return y;
    }

    Node insert(Node node, Contato contact) {
        if (node == null) return new Node(contact);

        if (contact.compareTo(node.data) < 0)
            node.esquerda = insert(node.esquerda, contact);
        else if (contact.compareTo(node.data) > 0)
            node.direita = insert(node.direita, contact);
        else
            return node;

        node.height = 1 + Math.max(height(node.esquerda), height(node.direita));

        int balance = balanceFactor(node);

        if (balance > 1 && contact.compareTo(node.esquerda.data) < 0)
            return rightRotate(node);

        if (balance < -1 && contact.compareTo(node.direita.data) > 0)
            return leftRotate(node);

        if (balance > 1 && contact.compareTo(node.esquerda.data) > 0) {
            node.esquerda = leftRotate(node.esquerda);
            return rightRotate(node);
        }

        if (balance < -1 && contact.compareTo(node.direita.data) < 0) {
            node.direita = rightRotate(node.direita);
            return leftRotate(node);
        }

        return node;
    }

    public void insert(String name, String phoneNumber) {
        root = insert(root, new Contato(name, phoneNumber));
    }

    void inOrderTraversal(Node node, StringBuilder result) {
        if (node != null) {
            inOrderTraversal(node.esquerda, result);
            result.append(node.data).append("\n");
            inOrderTraversal(node.direita, result);
        }
    }

    void inOrderTraversal() {
        StringBuilder result = new StringBuilder("Contatos em Ordem Alfabética:\n");
        inOrderTraversal(root, result);
        System.out.println(result.toString());
    }

    private boolean searchContactInTree(String nome) {
        return searchContactInTree(root, nome);
    }

    private boolean searchContactInTree(Node no, String nome) {
        if (no == null) {
            return false;
        }

        int compareResult = nome.compareToIgnoreCase(no.data.nome);

        if (compareResult == 0) {
            System.out.println("Contato encontrado na árvore AVL: " + no.data);
            return true;
        } else if (compareResult < 0) {
            return searchContactInTree(no.esquerda, nome);
        } else {
            return searchContactInTree(no.direita, nome);
        }
    }

    public boolean searchContactInTreePublic(String nome) {
        return searchContactInTree(nome);
    }

    public static ArvoreAvl loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArvoreAvl) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Node getRoot() {
        return root;
    }

    public static class Node implements Serializable {
        public Contato data;
        public Node esquerda, direita;
        public int height;

        public Node(Contato data) {
            this.data = data;
            this.height = 1;
        }

        public Contato getData() {
            return data;
        }

        public Node getEsquerda() {
            return esquerda;
        }

        public Node getDireita() {
            return direita;
        }

        public int getHeight() {
            return height;
        }
    }
}
