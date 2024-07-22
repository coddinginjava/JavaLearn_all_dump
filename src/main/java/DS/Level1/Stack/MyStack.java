package DS.Level1.Stack;

import java.util.Arrays;

public class MyStack {

    int size = 0;
    int[] items = new int[3];

    public void push(int value) {
        if (size >= items.length) {
            int[] temp = new int[size * 3];
            for (int i = 0; i < items.length; i++) {
                temp[i] = items[i];
            }
            items = temp;
        }
        items[size++] = value;
    }

    public int pop() {

        if (size >= items.length)
            throw new IllegalStateException();

        return items[--size];
    }

    public int peek() {
        return items[size-1];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(items,0,size));
    }

}
