package DS.study.LL;

import java.util.ArrayList;
import java.util.List;

public class Bst {




    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int item) {
            this.value = item;
        }

        @Override
        public String toString() {
            return "Node->" + value;
        }
    }

    private Node root;

    public void insert(int item) {
        Node newNode = new Node(item);
        if (root == null) {
            root = newNode;
            return;
        } else {
            Node current = root;

            while (true) {
                if (item < current.value) {
                    if (current.leftChild == null) {
                        current.leftChild = newNode;
                        return;
                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = newNode;
                        return;
                    }
                    current = current.rightChild;
                }
            }

        }
    }

    public boolean find(int i) {
        Node current = root;

        while (current != null) {
            if (i < current.value)
                current = current.leftChild;
            else if (i > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }


    public void traverserPreOrder() {
        traverserPreOrder(root);
    }

    private void traverserPreOrder(Node root) {
        if (root == null) return;
        System.out.println(root.value);
        traverserPreOrder(root.leftChild);
        traverserPreOrder(root.rightChild);
    }

    public void traverserInOrder() {
        traverserInOrder(root);
    }

    private void traverserInOrder(Node root) {
        if (root == null) return;
        traverserInOrder(root.leftChild);
        System.out.println(root.value);
        traverserInOrder(root.rightChild);
    }

    public void traverserPostOrder() {
        traverserPostOrder(root);
    }

    private void traverserPostOrder(Node root) {
        if (root == null) return;
        traverserPostOrder(root.leftChild);
        traverserPostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int BSTMin() {
        Node current = root;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    public int Max() {
        return max(root);
    }

    private int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int left = max(root.leftChild);
        int right = max(root.rightChild);
        return Math.max(root.value, Math.max(left, right));
    }

    private boolean isLeafNode(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }


    public boolean equals(Bst otherTree) {
        return equals(root, otherTree.root);
    }

    private boolean equals(Node root, Node otherRoot) {
        if (root == null && otherRoot == null)
            return true;
        if (root != null && otherRoot != null)
            return root.value == otherRoot.value
                    && equals(root.leftChild, otherRoot.leftChild)
                    && equals(root.rightChild, otherRoot.rightChild);

        return false;
    }

    public void swapRoot() {
       Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
    public boolean isBinarySearchTree() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;
        if (root.value > max || root.value < min)
            return false;
        return isBST(root.leftChild,min,root.value-1) && isBST(root.rightChild,root.value+1,max);
    }

    public List<Integer> getNodeAtDistance(int k) {
        List<Integer> list = new ArrayList<>();
        getNodeAtDistance(root,k,list);
        return list;
    }

    public void getNodeAtDistance(Node root, int distance, List<Integer> list){
        if(root==null)
            return;

        if(distance==0){
            list.add(root.value);
        }
        getNodeAtDistance(root.leftChild,distance-1,list);
        getNodeAtDistance(root.rightChild,distance-1,list);
    }

    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root==null)
            return -1;

        if(root.leftChild == null && root.rightChild==null)
            return 0;

        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

    public void levelOrderTraversal() {
        for(int i = 0 ; i <= height(); i++){
            System.out.println(getNodeAtDistance(i));
        }
    }
}
