package DS.most_orig.level3.Sorting_Algo.MergeSort_4;

import java.util.Arrays;

public class MainMergeSort {
    public static void main(String[] args) {

        int[] array = {5, 3, 7, 1, 6, 4, 2};

        new MergerSort().sort(array);

        System.out.println(Arrays.toString(array));
    }
}
