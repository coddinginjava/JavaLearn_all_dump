package DS.most_orig.level1.priorityQueue;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(1);
        pq.add(3);
        pq.add(9);
        pq.add(7);

        System.out.println(pq);

        System.out.println(pq.remove());

        pq.add(5);
        pq.add(1);

        System.out.println(pq.remove());

        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }

    }
}
