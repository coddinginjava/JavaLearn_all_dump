package DS.Level2.Graph_5;

import java.util.*;

public class MyDirectedGraph {

    private class Node {
        private String val;

        public Node(String val) {
            this.val = val;
        }

        public String toString() {
            return "🚀 " + val;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjNodes = new HashMap<>();

    public void insert(String val) {
        Node newNode = new Node(val);

        nodes.putIfAbsent(val, newNode);
        adjNodes.putIfAbsent(newNode, new ArrayList<>());
    }

    public void addEdge(String from, String to) {

        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException("something null");

        adjNodes.get(fromNode).add(toNode);
    }

    public void removeNode(String val) {
        Node node = nodes.get(val);

        if (val == null)
            return;

        for (Node n : adjNodes.keySet()) {
            adjNodes.get(n).remove(node);
        }
        adjNodes.remove(node);
        nodes.remove(val);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null)
            return;

        adjNodes.get(fromNode).remove(toNode);

    }

    public void depthFirstTraversalRec(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        depthFirstTraversalRec(node, new HashSet<Node>());
    }

    private void depthFirstTraversalRec(Node node, Set<Node> visited) {
        System.out.println(node);
        visited.add(node);

        for (Node neighbour : adjNodes.get(node)) {
            if (!visited.contains(neighbour))
                depthFirstTraversalRec(neighbour, visited);
        }
    }

    public void depthFirstTraversal(String root) {
        Node node = nodes.get(root);
        if (node == null)
            return;

        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        stack.add(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (Node neighbour : adjNodes.get(current)) {
                if (!visited.contains(neighbour))
                    stack.push(neighbour);
            }
        }
    }

    public void breathFirstTraversal(String root) {
        Node node = nodes.get(root);

        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);

            for (Node neighbor : adjNodes.get(current)) {
                if (!visited.contains(neighbor))
                    queue.add(neighbor);
            }
        }
    }

    public List<String> topologicalsort() {
        LinkedList<String> result = new LinkedList<>();
        Set<Node> set = new HashSet<>();

        for (Node node : nodes.values())
            topologicalsort(node, set, result);


        return result;
    }

    private void topologicalsort(Node node, Set<Node> visited, LinkedList<String> stack) {
        if (visited.contains(node))
            return;

        visited.add(node);

        for (Node neighbour : adjNodes.get(node)) {
            topologicalsort(neighbour, visited, stack);
        }

        stack.addFirst(node.val);
    }
}
