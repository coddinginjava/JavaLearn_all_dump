package DS.Level1.Queue;

import java.util.Arrays;

public class MyQueue {
    int[] items = new int[3];
    int front = 0, rear = 0;

    public void enqueue(int value) {
        if (rear >= items.length) {
            int[] temp = new int[rear * 3];
            for (int i = 0; i < items.length; i++) {
                temp[i] = items[i];
            }
            items = temp;
        }
        items[rear++] = value;
    }

    public int dequeue() {
        if(front>=rear)
            throw  new IllegalStateException("No elemt in quee");
        return items[front++];
    }

    public int peak() {
        return items[front];
    }

    public boolean isEmpty() {
        return front - rear == 0;
    }

    public int size() {
        return rear - front;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items, front, rear));
    }
}
