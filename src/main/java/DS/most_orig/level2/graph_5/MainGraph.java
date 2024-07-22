package DS.most_orig.level2.graph_5;

public class MainGraph {

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();

//        graph.insert("A");
//        graph.insert("B");
//        graph.insert("C");
//
//        graph.addEdge("A","B");
//        graph.addEdge("A","C");
//        graph.addEdge("B","C");

//        graph.print();
////        B -> [C]
////        A -> [B, C]

//        graph.removeNode("B");
//        graph.print(); //A -> [C]

//        graph.removeEdge("A","C");
//        graph.print();
////        B -> [C]
////        A -> [B]

//        graph.removeNode("D");
//        graph.print();// no change


//        graph.insert("A");
//        graph.insert("B");
//        graph.insert("C");
//        graph.insert("D");
//        graph.insert("E");
//
//        graph.addEdge("A","B");
//        graph.addEdge("B","D");
//        graph.addEdge("D","C");
//        graph.addEdge("A","C");
//        graph.addEdge("A","E");
//          -> B ->  D
//        A         /down arrow
//          -> C


//        B -> [D]
//        A -> [B, C]
//        D -> [C]

//        graph.print();


//        graph.depthFirstTraversalRec("A");  // A B D C E


//        graph.depthFirstTraversal("A");  // A C B D
//        graph.depthFirstTraversal("C");   //only shows the source C wiht no edges , if invalid like R the output is empty


//        graph.breathFirstTraversal("A"); // A B C D

//
//        graph.insert("X");
//        graph.insert("A");
//        graph.insert("B");
//        graph.insert("P");
//
//        graph.addEdge("X", "A");
//        graph.addEdge("X", "B");
//        graph.addEdge("A", "P");
//        graph.addEdge("B", "P");
//
//
//        System.out.println(graph.topologicalsort());//X B A P   or  X A B P


        graph.insert("A");
        graph.insert("B");
        graph.insert("C");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
//        graph.addEdge("A", "C"); //false don't have a cycle
        graph.addEdge("C", "A"); // true has a cycle

        System.out.println(graph.hasCycle());
    }


}
