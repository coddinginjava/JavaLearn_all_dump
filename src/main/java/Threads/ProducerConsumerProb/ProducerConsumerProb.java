package Threads.ProducerConsumerProb;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProb {
    public static void main(String[] args) {

        MessageQueue queue = new MessageQueue(3);
        Thread t1 = new Thread(new Producer(queue));
        Thread t2 = new Thread(new Cosnumer(queue));

        t1.start();
        t2.start();


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Cosnumer implements Runnable {
    MessageQueue queue;

    public Cosnumer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            int dequeue = queue.dequeue();
            System.out.println(dequeue);
        }
    }
}

class Producer implements Runnable {
    MessageQueue queue;

    public Producer(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            queue.enqueue(i);
        }
    }
}


class MessageQueue {
    private List<Integer> ls;
    private int size;

    public MessageQueue(int size) {
        ls = new ArrayList<>();
        this.size = size;
    }

    public boolean isFull() {
        return ls.size() == size;
    }

    public boolean isEmpty() {
        return ls.isEmpty();
    }

    public void enqueue(int i) {
        while (isFull()) {

        }
        ls.add(i);
    }

    public int dequeue() {

        while (isEmpty()) {

        }

        int removed = ls.remove(0);
        return removed;
    }
}
