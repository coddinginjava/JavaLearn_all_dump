package DS.most_orig.level3.Sorting_Algo.Bubble_Sort_1;

import java.util.Arrays;

public class MainBubbleSort {
    public static void main(String[] args) {
        int[] arr = {7,3,6,5,4,2,1};
        new BubbleSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
