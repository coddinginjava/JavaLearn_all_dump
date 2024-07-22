package DS.most_orig.level3.Sorting_Algo.BucketSort_7;

import java.util.Arrays;

public class MainBucketSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 2, 5, 4, 4, 5};
        new BucketSort().sort(array,3);

        System.out.println(Arrays.toString(array));
    }
}
