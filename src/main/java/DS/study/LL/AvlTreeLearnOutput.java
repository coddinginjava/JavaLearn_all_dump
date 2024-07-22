package DS.study.LL;

public class AvlTreeLearnOutput {

    private class Node {
        private int height;
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
        root = insert(root, value);
    }

    private Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        setHeight(root);

        return balanced(root);
    }

    private Node balanced(Node root) {

        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
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

    private boolean isLeftHeavy(Node root) {
        return balanceFactor(root) > 1;
    }

    private boolean isRightHeavy(Node root) {
        return balanceFactor(root) < -1;
    }

    private int balanceFactor(Node root) {
        return root == null ? 0 : height(root.leftChild) - height(root.rightChild);
    }

    private void setHeight(Node root) {
        root.height = 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private int height(Node root) {
        return root == null ? -1 : root.height;
    }


}
