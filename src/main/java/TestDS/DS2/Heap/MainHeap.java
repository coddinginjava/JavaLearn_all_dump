package TestDS.DS2.Heap;

import java.util.PriorityQueue;

public class MainHeap {
    public static void main(String[] args) {

        Heap h = new Heap();

        h.insert(17);
        h.insert(5);
        h.insert(1);
        h.insert(20);
        h.insert(9);
        h.insert(25);

        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());
        System.out.println(h.remove());

        System.out.println("done");


    }
}
