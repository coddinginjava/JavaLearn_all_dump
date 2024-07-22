package DS.most_orig.level1.Arrays;

import java.util.ArrayList;

public class MyArray {
    private int[] arr = new int[3];
    private int count = 0;

    private ArrayList <Integer> ls = new ArrayList<>();


    public void insert(int item) {
        if (count >= arr.length) {
            int[] temp = new int[count * 2];

            for (int i = 0; i < count; i++)
                temp[i] = arr[i];

            arr = temp;
        }
        arr[count++] = item;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.print(arr[i] + " ");

    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == item)
                return i;
        }
        return -1;
    }

    public void removeAt(int index) {
        if (index >= count || index < 0)
            throw new IllegalArgumentException();
        for (int i = index; i < count; i++)
            arr[i] = arr[i + 1];
        count--;
    }
}

