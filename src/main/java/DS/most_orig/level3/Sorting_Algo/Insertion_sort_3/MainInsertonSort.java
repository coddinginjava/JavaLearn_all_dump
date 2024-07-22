package DS.most_orig.level3.Sorting_Algo.Insertion_sort_3;

import java.util.Arrays;

public class MainInsertonSort {

    public static void main(String[] args) {
        int[] array = {5,3,7,1,6,4,2};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);

        System.out.println(Arrays.toString(array));
    }

}
