public class ArvoreAVL {
    private Node root;

    public ArvoreAVL() {
        this.root = null;
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    private Node insert(Node node, long data) {
        if (node == null)
            return new Node(data);

        if (data < node.getData())
            node.setLeft(insert(node.getLeft(), data));
        else if (data > node.getData())
            node.setRight(insert(node.getRight(), data));
        else
            return node;

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);

        if (balance > 1 && data < node.getLeft().getData())
            return rightRotate(node);

        if (balance < -1 && data > node.getRight().getData())
            return leftRotate(node);

        if (balance > 1 && data > node.getLeft().getData()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && data < node.getRight().getData()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    public void insert(long data) {
        root = insert(root, data);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    public void printInOrder() {
        inOrder(root);
        System.out.println();
    }

}
