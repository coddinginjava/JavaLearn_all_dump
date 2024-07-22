package DS.most_orig.level3.Sorting_Algo.CountingSort_6;

import java.util.Arrays;

public class MainCountingSort {
    public static void main(String[] args) {

        int[] array = {5,3,2,5,4,4,5};

       new CountingSort().sort(array,5);

        System.out.println(Arrays.toString(array));

    }
}
