package DS.most_orig.level2.bst_1.seoncd;

import java.util.ArrayList;
import java.util.List;

public class MyBST {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChld;

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
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node current = root;

        while (current != null) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChld == null) {
                    current.rightChld = new Node(value);
                    break;
                }
                current = current.rightChld;
            }
        }
    }

    public boolean find(int item) {
        Node current = root;

        while (current != null) {
            if (item < current.value) {
                current = current.leftChild;
            } else if (item > current.value) {
                current = current.rightChld;
            } else
                return true;
        }
        return false;
    }

    public void traverserPretOrder() {
        traverserPretOrder(root);
    }

    private void traverserPretOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        traverserPretOrder(root.leftChild);
        traverserPretOrder(root.rightChld);
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
        traverserInOrder(root.rightChld);
    }

    public void traverserPostOrder() {
        traverserPostOrder(root);
    }

    private void traverserPostOrder(Node root) {
        if (root == null)
            return;
        traverserPostOrder(root.leftChild);
        traverserPostOrder(root.rightChld);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        if (root.leftChild == null && root.rightChld == null)
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChld));
    }


    public int BSTmin() {

        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = max(root.leftChild);
        int right = max(root.rightChld);
        return Math.max(root.value, Math.max(left, right));
    }


    public boolean equals(MyBST other) {
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node root, Node other) {
        if (root == null && other == null)
            return true;
        if (root != null && other != null)
            return root.value == other.value
                    &&
                    equals(root.leftChild, other.leftChild)
                    &&
                    equals(root.rightChld, other.rightChld);

        return false;
    }

    public void swapRoot() {
        Node temp = root.rightChld;
        root.rightChld = root.leftChild;
        root.leftChild = temp;
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
                &&
                isBinarySearhTree(root.rightChld, root.value + 1, max);
    }

    public List<Integer> getNodeAtDistance(int value) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodeAtDistance(root, value, list);
        return list;
    }

    private void getNodeAtDistance(Node root, int distace, List<Integer> ls) {

        if (root == null)
            return;
        if (distace == 0) {
            ls.add(root.value);
            return;
        }
        getNodeAtDistance(root.leftChild, distace - 1, ls);
        getNodeAtDistance(root.rightChld, distace - 1, ls);

    }

    public void levelOrderTraversal() {
        for (int i = 0; i <= height(); i++) {
            System.out.println(getNodeAtDistance(i));
        }
    }

}
