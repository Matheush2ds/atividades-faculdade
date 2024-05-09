import java.util.Random;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    private TreeNode createBackbone(TreeNode root) {
        TreeNode tmpRoot = new TreeNode(0);
        tmpRoot.right = root;

        TreeNode prev = tmpRoot;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                TreeNode temp = curr.left;
                curr.left = temp.right;
                temp.right = curr;
                prev.right = temp;
            }

            prev = curr;
            curr = curr.right;
        }

        return tmpRoot.right;
    }

    private void createBalancedTree(TreeNode root, int n) {
        int m = (int) Math.pow(2, Math.floor(Math.log(n + 1) / Math.log(2))) - 1;
        compress(root, n - m);
        for (; m > 1; m /= 2) {
            compress(root, m);
        }
    }

    private void compress(TreeNode root, int count) {
        TreeNode scanner = root;
        for (int i = 0; i < count; i++) {
            TreeNode child = scanner.right;
            scanner.right = child.right;
            scanner = scanner.right;
            child.right = scanner.left;
            scanner.left = child;
        }
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void printInorder() {
        inorder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            tree.insert(rand.nextInt(101));
        }

        System.out.println("Árvore original:");
        tree.printInorder();

        for (int i = 0; i < 20; i++) {
            tree.insert(rand.nextInt(101));
        }

        System.out.println("Árvore com 120 números:");
        tree.printInorder();

        tree.root = tree.createBackbone(tree.root);
        tree.createBalancedTree(tree.root, 120);

        System.out.println("Árvore balanceada:");
        tree.printInorder();
    }
}
