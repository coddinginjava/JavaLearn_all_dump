package DS.Level1.Queue;

import java.util.Queue;

public class MainQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();



        int size = queue.size();
        System.out.println("size = " + size);


        
        int dequeue = queue.dequeue();
        System.out.println("dequeue = " + dequeue);



        int dequeue1 = queue.dequeue();
        System.out.println("dequeue = " + dequeue1);

        System.out.println("queue = " + queue.toString());

        int peek = queue.peak();
        System.out.println("peek = " + peek);

        boolean isEmpty = queue.isEmpty();
        System.out.println("isEmpty = " + isEmpty);
        
    }
}
