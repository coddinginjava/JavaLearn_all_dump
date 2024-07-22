package DS.most_orig.level2.UndirectedGraph_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUndirectedGraphHashMap {

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
    private Map<Node, List<Edge>> adjNode = new HashMap<>();

    public void insert(String label) {
        Node node = new Node(label);

        nodes.putIfAbsent(label, node);

        adjNode.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalStateException();

        Node toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalStateException();

        adjNode.get(fromNode).add(new Edge(fromNode, toNode, weight));

        adjNode.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print(){
        for(Node n : nodes.values()){
            if(!adjNode.get(n).isEmpty())
                System.out.println(n +" is connected to" + adjNode.get(n));
        }
    }

}
