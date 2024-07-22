package DS.most_orig.level2.AVLTree_2;

public class AVL {

    private class Node {
        private int value;
        private int height;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node-> " + value + " : height->" + height;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else if (value > root.value) {
            root.rightChild = insert(root.rightChild, value);
        }

        setHeight(root);

        return balance(root);

    }

    public Node balance(Node root) {

        if (isLeftHeavy(root)) {

            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);  //   System.out.println("rotate left " + root.leftChild.value);

            return rotateRight(root);  // System.out.println("rotate right" + root.value);

        } else if (isRightHeavy(root)) {

            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);// System.out.println("rotate right" + root.rightChild.value);

            return rotateLeft(root);// System.out.println("rotate left" + root.value);
        }

        return root;
    }

    private Node rotateLeft(Node root) {
        Node newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private Node rotateRight(Node root) {
        Node newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(Node node) {
        return node == null ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private void setHeight(Node node) {
        node.height = 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    private int height(Node node) {
        return (node == null) ? -1 : node.height;
    }

    public boolean isbalanced() {
        return isbalanced(root);
    }

    private boolean isbalanced(Node root) {

        if (root == null)
            return true;

        if (Math.abs(balanceFactor(root)) > 1) {
            return false;
        }

        return isbalanced(root.leftChild) && isbalanced(root.rightChild);
    }

}
