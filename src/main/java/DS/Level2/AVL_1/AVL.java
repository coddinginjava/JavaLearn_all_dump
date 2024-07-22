package DS.Level2.AVL_1;

public class AVL {

    private class Node {
        private int val;
        private int height;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        public String toString() {
            return "🚀 ➡ " + val;
        }
    }

    private Node root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node root, int val) {
        if (root == null)
            return new Node(val);
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if(val > root.val){
            root.right = insert(root.right, val);
        }

        setHeight(root);

        return balance(root);
    }

    private Node balance(Node root) {

        if (isLeftHeavy(root)) {
            if (balanceFactor(root.left) < 0)
                root.left = rotateLeft(root.left);
            return rotateRight(root);
        } else if (isRightHeavy(root)) {
            if (balanceFactor(root.right) > 0)
                root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    private Node rotateRight(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private Node rotateLeft(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private boolean isRightHeavy(Node node) {
        return balanceFactor(node) < -1;
    }

    private boolean isLeftHeavy(Node node) {
        return balanceFactor(node) > 1;
    }

    private int balanceFactor(Node node) {
        return node == null ? 0 : height(root.left) - height(root.right);
    }

    private void setHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }
}
