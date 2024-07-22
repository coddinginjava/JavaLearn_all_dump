package DS.most_orig.level2.bst_1;

import java.util.ArrayList;

public class BST {
    private class Node {
        private int value;
        private Node rightChild;
        private Node leftChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node ->" + value;
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
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {

        Node current = root;

        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traverserPreOrder() {
        traverserPreOrder(root);
    }

    private void traverserPreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        traverserPreOrder(root.leftChild);
        traverserPreOrder(root.rightChild);
    }

    public void traverserInOrder() {
        traverserInOrder(root);
    }

    private void traverserInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverserInOrder(root.leftChild);
        System.out.println(root.value);
        traverserInOrder(root.rightChild);
    }

    public void traverserPostOrder() {
        traverserPostOrder(root);
    }

    private void traverserPostOrder(Node root) {
        if (root == null) {
            return;
        }

        traverserPostOrder(root.leftChild);
        traverserPostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {

//		if (root.leftChild == null && root.rightChild == null)
//			return root.value;

        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(root.value, Math.min(left, right));
    }

    public int BSTmin() {
        if (root == null)
            throw new IllegalArgumentException();

        Node current = root;
        Node last = null;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    public boolean equals(BST other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

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
        ArrayList<Integer> list = new ArrayList<>();
        getNodeAtDistance(root, distance, list);
        return list;
    }

    private void getNodeAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (distance == 0)
            list.add(root.value);

        getNodeAtDistance(root.leftChild, distance - 1, list);
        getNodeAtDistance(root.rightChild, distance - 1, list);

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
        return countTheNode();
    }

    private int countTheNode(Node node) {
        if (root == null)
            return 0;
        return (1 + countTheNode(node.leftChild) + countTheNode(node.rightChild));
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

}
