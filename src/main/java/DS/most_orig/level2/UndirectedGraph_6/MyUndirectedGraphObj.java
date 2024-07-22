package DS.most_orig.level2.UndirectedGraph_6;

import java.util.*;

public class MyUndirectedGraphObj {

    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;


        private Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
//    private Map<Node, List<Edge>> adjNode = new HashMap<>();

    public void insert(String label) {
        Node node = new Node(label);

        nodes.putIfAbsent(label, node);

//        adjNode.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalStateException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalStateException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);

//        adjNode.get(fromNode).add(new Edge(fromNode, toNode, weight));
//        adjNode.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print() {
        for (Node n : nodes.values()) {
            if (!n.getEdges().isEmpty())
                System.out.println(n + " is connected to" + n.getEdges());
        }
    }

    private class NodeEntry {
        private Node node;
        private int weight;

        public NodeEntry(Node node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public Path shortestpath(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalStateException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalStateException();

        Map<Node, Integer> distances = new HashMap<>();

        for (Node n : nodes.values())
            distances.put(n, Integer.MAX_VALUE);

        distances.replace(fromNode, 0);

        Set<Node> visited = new HashSet<>();
        Map<Node, Node> previous = new HashMap<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.weight));

        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visited.add(current);

            for (Edge edge : current.edges) {
                Node neighbour = edge.to;

                if (visited.contains(neighbour))
                    continue;

                int newDistance = distances.get(current) + edge.weight;

                if (newDistance < distances.get(neighbour)) {
                    distances.replace(neighbour, newDistance);
                    queue.add(new NodeEntry(neighbour, newDistance));
                    previous.put(neighbour, current);
                }
            }
        }


        Stack<Node> stack = new Stack<>();
        stack.push(toNode);

        Node prevNode = previous.get(toNode);

        while (prevNode != null) {
            stack.push(prevNode);
            prevNode = previous.get(prevNode);
        }
        Path path = new Path();
        while (!stack.isEmpty()) {
            path.add(stack.pop().label);
        }

        return path;
    }

    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();

        for (Node n : nodes.values()) {
            if (!visited.contains(n))
                if (hasCycle(n,null,visited))
                    return true;
        }
        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {

        visited.add(node);

        for (Edge edge : node.getEdges()) {

            if (edge.to == parent)
                continue;

            if (visited.contains(edge.to))
                return true;

            if (hasCycle(edge.to, node, visited))
                return true;
        }
        return false;
    }

}
