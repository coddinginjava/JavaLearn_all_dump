package DS.most_orig.level2.Tries_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTiresUsingHashMapOptimised {

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char ch) {
            this.value = ch;
        }


        public String toString() {
            return "value -> " + value;
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

    }


    private Node root = new Node(' ');


    public void insert(String word) {
        Node current = root;

        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;

            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void remove(String word) {

        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        char ch = word.charAt(index);
        Node child = root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = findtheLastNodeOf(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {

        if (root == null)
            return;

        if (root.isEndOfWord) {
            words.add(prefix);
        }

        for (Node child : root.getChildren()) {
            findWords(child, prefix + child.value, words);
        }


    }

    private Node findtheLastNodeOf(String prefix) {
        if (prefix == null)
            return null;
        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }
}

