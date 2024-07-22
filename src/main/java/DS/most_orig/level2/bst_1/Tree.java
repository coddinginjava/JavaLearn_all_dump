package DS.most_orig.level2.bst_1;

import java.util.ArrayList;

public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node -> " + value;
        }

    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }

    }

    public boolean find(int value) {
        if (root == null)
            throw new IllegalStateException();

        Node current = root;

        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traverserPretOrder() {
        traverserPretOrder(root);
    }

    private void traverserPretOrder(Node root) {
        if (root == null)
            return;
        System.out.println(root.value);
        traverserPretOrder(root.leftChild);
        traverserPretOrder(root.rightChild);
    }

    public void traverserInOrder() {
        traverserInOrder(root);
    }

    private void traverserInOrder(Node root) {
        if (root == null)
            return;
        traverserInOrder(root.leftChild);
        System.out.println(root.value);
        traverserInOrder(root.rightChild);

    }

    public void traverserPostOrder() {
        traverserPostOrder(root);
    }

    private void traverserPostOrder(Node root) {
        if (root == null)
            return;

        traverserPostOrder(root.leftChild);
        traverserPostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        if (root.leftChild == null && root.rightChild == null)
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int BSTmin() {
        if (root == null)
            return -1;
        Node last = null;
        Node current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(root.value, Math.min(left, right));

    }

    public boolean equals(Tree other) {

        return equals(root, other.root);
    }

    private boolean equals(Node root, Node other) {
        if (root == null && other == null)
            return true;
        if (root != null && other != null)
            return root.value == other.value && equals(root.leftChild, other.leftChild) &&
                    equals(root.rightChild, other.rightChild);
        return false;
    }

    public boolean isBinarySearhTree() {
        return isBinarySearhTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearhTree(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;

        return isBinarySearhTree(root.leftChild, min, root.value - 1)
                && isBinarySearhTree(root.rightChild, root.value + 1, max);

    }

    public void swapRoot() {
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;

    }

    public ArrayList<Integer> getNodeAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        getNodeAtDistance(root, distance, list);
        return list;
    }

    private void getNodeAtDistance(Node root, int distace, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (distace == 0) {
            list.add(root.value);
            return;
        }
        getNodeAtDistance(root.leftChild, distace - 1, list);
        getNodeAtDistance(root.rightChild, distace - 1, list);

    }

    public void levelOrderTraversal() {
        for (int i = 0; i <= height(); i++) {
            System.out.println(getNodeAtDistance(i));

        }
    }

    public boolean isSymmetric() {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a != null && b != null)
            return a.value == b.value &&
                    isSymmetric(a.leftChild, b.rightChild) &&
                    isSymmetric(a.rightChild, b.leftChild);

        return false;
    }

    public int minHeight() {
        return minimumDepth(root, 0);
    }

    private int minimumDepth(Node root, int level) {
        if (root == null)
            return level;
        level++;

        return Math.min(minimumDepth(root.leftChild, level),
                minimumDepth(root.rightChild, level));
    }

    public int countTheNode() {
        return countTheNode(root);
    }

    private int countTheNode(Node node) {
        if (node == null)
            return 0;
        return (1 + countTheNode(node.leftChild) + countTheNode(node.rightChild));
    }

    public final boolean isCompelete() {
        int noOfNodes = countTheNode(root);
        int index = 0;
        return isCompelete(root, index, noOfNodes);
    }

    private boolean isCompelete(Node root, int index, int noOfNodes) {
        if (root == null)
            return true;
        if (index >= noOfNodes)
            return false;

        return isCompelete(root.leftChild, 2 * index + 1, noOfNodes)
                &&
                isCompelete(root.rightChild, 2 * index + 2, noOfNodes);
    }

    public boolean isFullBinaryTree() {
        return isFullBinaryTree(root);
    }

    private boolean isFullBinaryTree(Node root) {
        if (root == null)
            return true;
        if (root.leftChild == null && root.rightChild == null)
            return true;
        if (root.leftChild != null && root.rightChild != null)
            return isFullBinaryTree(root.leftChild) && isFullBinaryTree(root.rightChild);

        return false;

    }

    public int sumOfAllNodes() {
        return sumOfAllNodes(root);
    }

    private int sumOfAllNodes(Node root) {
        if (root == null)
            return 0;
        return root.value + sumOfAllNodes(root.leftChild) + sumOfAllNodes(root.rightChild);
    }

    public int sumOfALlLeaf() {
        int sum = 0;
        return sumOfALlLeaf(root, sum);
    }

    private int sumOfALlLeaf(Node root, int sum) {
        if (root == null)
            return sum;
        if (root.leftChild == null && root.rightChild == null)
            return sum + root.value;
        return sumOfALlLeaf(root.leftChild, sum) + sumOfALlLeaf(root.rightChild, sum);
    }
}
