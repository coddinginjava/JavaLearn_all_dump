package DS.Level2.Tries_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTires {

    private class Node {
        private Character val;
        private Map<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(int value) {
            this.val = val;
        }

        public String toString() {
            return "Node ➡" + this.val;
        }

        public boolean hasChild(char c) {
            return children.containsKey(c);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }


        public void addChild(char c) {
            children.put(c, new Node(c));
        }

        public Node getChild(char c) {
            return children.get(c);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char c) {
            children.remove(c);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {

        Node current = root;

        for (char c : word.toCharArray()) {
            if (!current.hasChild(c))
                current.addChild(c);
            current = current.getChild(c);
        }
        current.isEndOfWord = true;
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }
        char c = word.charAt(index);
        Node child = root.getChild(c);

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(c);
    }

    public List<String> findListOfWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastPrefixNode = getLastPrefixNode(prefix);

        listOfWords(lastPrefixNode, prefix, words);
        return words;
    }

    private void listOfWords(Node root, String prefix, List<String> word) {

        if (root == null)
            return;

        if (root.isEndOfWord) {
            word.add(prefix);
        }

        for (Node n : root.getChildren()) {
            listOfWords(n, prefix + root.val, word);
        }
    }

    private Node getLastPrefixNode(String prefix) {
        if (prefix == null)
            return null;
        Node current = root;

        for (char c : prefix.toCharArray()) {
            Node child = current.getChild(c);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }
}
