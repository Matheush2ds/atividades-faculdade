import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int key, color, count, height;
    Node parent, left, right;

    Node(int key) {
        this.key = key;
        this.color = 1;
        this.count = 1;
        this.height = 1;
    }
}

class RedBlackTree {
    private Node root;
    private Node TNULL;

    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node root, int key) {
        if (root == TNULL) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
            root.left.parent = root;
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
            root.right.parent = root;
        } else {
            root.count++;
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        // Left Heavy
        if (balance > 1) {
            if (key < root.left.key) {
                return rotateRight(root);
            } else if (key > root.left.key) {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (key > root.right.key) {
                return rotateLeft(root);
            } else if (key < root.right.key) {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        return root;
    }

    public void remove(int key) {
        // Implemente a remoção aqui
    }

    public int countOccurrences(int key) {
        return countOccurrences(root, key);
    }

    private int countOccurrences(Node root, int key) {
        if (root == TNULL) {
            return 0;
        }

        if (key == root.key) {
            return root.count;
        } else if (key < root.key) {
            return countOccurrences(root.left, key);
        } else {
            return countOccurrences(root.right, key);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root != TNULL) {
            inOrderTraversal(root.left);
            System.out.print(root.key + "(" + root.count + ") ");
            inOrderTraversal(root.right);
        }
    }

    private int height(Node node) {
        return (node != TNULL) ? node.height : 0;
    }

    private int getBalance(Node node) {
        return (node != TNULL) ? height(node.left) - height(node.right) : 0;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }
}

class AVLTree {
    private Node root;

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        } else {
            root.count++;
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if (balance > 1) {
            if (key < root.left.key) {
                return rotateRight(root);
            } else if (key > root.left.key) {
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }

        if (balance < -1) {
            if (key > root.right.key) {
                return rotateLeft(root);
            } else if (key < root.right.key) {
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }

        return root;
    }

    public void remove(int key) {
        // Implemente a remoção aqui
    }

    public int countOccurrences(int key) {
        return countOccurrences(root, key);
    }

    private int countOccurrences(Node root, int key) {
        if (root == null) {
            return 0;
        }

        if (key == root.key) {
            return root.count;
        } else if (key < root.key) {
            return countOccurrences(root.left, key);
        } else {
            return countOccurrences(root.right, key);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + "(" + root.count + ") ");
            inOrderTraversal(root.right);
        }
    }

    private int height(Node node) {
        return (node != null) ? node.height : 0;
    }

    private int getBalance(Node node) {
        return (node != null) ? height(node.left) - height(node.right) : 0;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }
}

public class TreeComparison {
    public static void main(String[] args) {
        List<Integer> numbers = readNumbersFromFile("numbers.txt");

        AVLTree avlTree = new AVLTree();
        long avlStartTime = System.currentTimeMillis();
        for (int number : numbers) {
            avlTree.insert(number);
        }
        long avlInsertTime = System.currentTimeMillis() - avlStartTime;

        RedBlackTree redBlackTree = new RedBlackTree();
        long redBlackStartTime = System.currentTimeMillis();
        for (int number : numbers) {
            redBlackTree.insert(number);
        }
        long redBlackInsertTime = System.currentTimeMillis() - redBlackStartTime;

        for (int i = 0; i < 50000; i++) {
            int randomNumber = (int) (Math.random() * 19999) - 9999;

            if (randomNumber % 3 == 0) {
                avlTree.insert(randomNumber);
                redBlackTree.insert(randomNumber);
            } else if (randomNumber % 5 == 0) {
                redBlackTree.remove(randomNumber);
            } else {
                int avlCount = avlTree.countOccurrences(randomNumber);
                int redBlackCount = redBlackTree.countOccurrences(randomNumber);
                System.out.println("Number: " + randomNumber + ", AVL Count: " + avlCount + ", Red-Black Count: " + redBlackCount);
            }
        }

        System.out.println("AVL Insert Time: " + avlInsertTime + " milliseconds");
        System.out.println("Red-Black Insert Time: " + redBlackInsertTime + " milliseconds");

        System.out.println("AVL In-Order Traversal:");
        avlTree.inOrderTraversal();

        System.out.println("\nRed-Black In-Order Traversal:");
        redBlackTree.inOrderTraversal();
    }

    private static List<Integer> readNumbersFromFile(String filename) {
        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numbers;
    }
}
