package DS.most_orig.level2.graph_5;

import java.util.*;

public class MyGraph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();

    private Map<Node, List<Node>> adjList = new HashMap<>();

    public void insert(String label) {
        Node node = new Node(label);

        nodes.putIfAbsent(label, node);
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {

        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalStateException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalStateException();

        adjList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);

        if (node == null)
            return;

        for (Node n : adjList.keySet())
            adjList.get(n).remove(node);

        adjList.remove(node);

        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            return;

        adjList.get(fromNode).remove(toNode);
    }

    public void print() {

        for (Node source : adjList.keySet())
            if (!adjList.get(source).isEmpty())
                System.out.println(source + " -> " + adjList.get(source));
    }

    public void depthFirstTraversalRec(String from) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            return;
        depthFirstTraversalRec(fromNode, new HashSet<>());
    }

    private void depthFirstTraversalRec(Node root, Set<Node> visited) {

        System.out.println(root);
        visited.add(root);

        for (Node n : adjList.get(root))
            if (!visited.contains(n))
                depthFirstTraversalRec(n, visited);
    }

    public void depthFirstTraversal(String from) {
        Node node = nodes.get(from);

        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (visited.contains(current))
                return;

            System.out.println(current);
            visited.add(current);

            for (Node n : adjList.get(current))
                if (!visited.contains(n))
                    stack.push(n);
        }
    }

    public void breathFirstTraversal(String from) {
        Node node = nodes.get(from);

        if (node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while ((!queue.isEmpty())) {
            Node current = queue.remove();

            if (visited.contains(current))
                return;

            System.out.println(current);
            visited.add(current);

            for (Node n : adjList.get(current))
                if (!visited.contains(n))
                    queue.add(n);
        }
    }

    public List<String> topologicalsort() {
        List<String> finalList = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        for (Node n : nodes.values())
            topologicalsort(n, visited, stack);

        while (!stack.isEmpty())
            finalList.add(stack.pop().label);

        return finalList;
    }

    private void topologicalsort(Node n, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(n))
            return;

        visited.add(n);

        for (Node child : adjList.get(n))
            topologicalsort(child, visited, stack);

        stack.push(n);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();

        while (!all.isEmpty()) {
            Node current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited))
                return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (Node n : adjList.get(node)) {

            if (visited.contains(n))
                continue;
            if (visiting.contains(n))
                return true;
            if (hasCycle(n, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }


}

