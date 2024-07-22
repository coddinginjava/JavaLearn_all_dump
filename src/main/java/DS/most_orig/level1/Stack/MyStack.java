package DS.most_orig.level1.Stack;

import java.util.Arrays;

public class MyStack {

    private int[] items = new int[3];
    private int size=0;

    public void push(int item) {
        if (size >= items.length) {
            int[] temp = new int[size * 4];

            for (int i = 0; i < size; i++) {
                temp[i] = items[i];
            }
            items = temp;
        }
        items[size++] = item;
    }

    public int pop() {
        if (size == 0)
            throw new IllegalArgumentException("the stack is empty");
        return items[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek(){
        return items[size-1];
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(items,0,size);
        return Arrays.toString(content);
    }
}
