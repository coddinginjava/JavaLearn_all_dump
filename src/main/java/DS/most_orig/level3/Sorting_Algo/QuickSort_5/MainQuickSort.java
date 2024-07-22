package DS.most_orig.level3.Sorting_Algo.QuickSort_5;

import java.util.Arrays;

public class MainQuickSort {

    public static void main(String[] args) {

        int[] array = {5, 3, 7, 1, 6, 4, 2};

        new QuickSort().sort(array);

        System.out.println(Arrays.toString(array));
    }
}
