package DS.most_orig.level2.Tries_4;

public class MyTriesUsingNode {
    public static int NODE_SIZE = 26;

    private class Node {
        private char value;
        private Node[] children = new Node[NODE_SIZE];
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null)
                current.children[index] = new Node(ch);

            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
}
