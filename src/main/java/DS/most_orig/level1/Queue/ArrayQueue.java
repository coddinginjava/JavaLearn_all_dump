package DS.most_orig.level1.Queue;

import java.util.Arrays;

public class ArrayQueue {
    private int front;
    private int rear;
    private int[] arr = new int[3];

    public void enqueue(int item) {

        if (rear >= arr.length) {
            int[] temp = new int[rear * 3];
            for (int i = 0; i < rear; i++)
                temp[i] = arr[i];
            arr = temp;
        }
        arr[rear++] = item;
    }

    public int dequeue() {
        return arr[front++];
    }

    public int peek() {
        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(arr, front, rear);
        return Arrays.toString(content);
    }
}
