package DS.Level2.BST_1;

import java.util.ArrayList;
import java.util.List;

public class BST {
    /*
     *insert 🚀
     * find
     * traverserPreOrder
     * traverserInOrder
     * traverserPostOrder
     * height
     * min
     * BSTmin
     * equals
     * isBinarySearchTree swapRoot
     * getNodeAtDistance
     * levelOrderTraversal
     * */

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "val 🚀 " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        Node current = root;

        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new Node(value);
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(value);
                    break;
                }
                current = current.right;
            }
        }
    }

    public boolean find(int value) {

        if (root == null)
            return false;
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        if (root.left == null && root.right == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int Max() {
        return Max(root);
    }

    private int Max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int left = Max(root.left);
        int right = Max(root.right);

        return Math.max(root.value, Math.max(left, right));
    }

    public int BSTMin() {
        Node current = root;
        Node last = current;

        while (current != null) {
            last = current;
            current = current.left;
        }
        return last.value;
    }

    public boolean equals(BST other) {
        return equals(root, other.root);
    }

    private boolean equals(Node root, Node other) {
        if (root == null && other == null)
            return true;

        if (root != null && other != null)
            return (root.value == other.value) &&
                    equals(root.left, other.left) &&
                    equals(root.right, other.right);

        return false;
    }

    public void swapRoot() {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int left, int right) {
        if (root == null)
            return true;

        if (root.value < left || root.value > right)
            return false;

        return isBinarySearchTree(root.left, left, root.value - 1) &&
                isBinarySearchTree(root.right, root.value + 1, right);
    }

    public List<Integer> getNodeAtDistance(int distance) {
        List<Integer> list = new ArrayList<>();
        getNodeAtDistance(root, distance, list);
        return list;
    }

    private void getNodeAtDistance(Node root, int d, List<Integer> list) {
        if (root == null)
            return;
        if (d == 0)
            list.add(root.value);

        getNodeAtDistance(root.left, d - 1, list);
        getNodeAtDistance(root.right, d - 1, list);
    }

    public List<List<Integer>> levelOrderTraversal() {
        List<List<Integer>> ls = new ArrayList<>();
        int height = height(root);
        for (int i = 0; i <= height; i++) {
            ls.add(getNodeAtDistance(i));
        }
        return ls;
    }
}
