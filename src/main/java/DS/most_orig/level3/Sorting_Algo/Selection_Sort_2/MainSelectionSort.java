package DS.most_orig.level3.Sorting_Algo.Selection_Sort_2;

import java.util.Arrays;

public class MainSelectionSort {

    public static void main(String[] args) {

        int[] array = {3,4,1,7,2,5,6};

        new SelectionSort().sort(array);

        System.out.println(Arrays.toString(array));

    }
}
