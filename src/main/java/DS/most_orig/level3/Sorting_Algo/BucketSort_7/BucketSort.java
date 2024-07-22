package DS.most_orig.level3.Sorting_Algo.BucketSort_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public void sort(int[] array, int numberOfBucket) {
        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < numberOfBucket; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int item : array) {
            buckets.get(item / numberOfBucket).add(item);
        }

        int k = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int item : bucket) {
                array[k++] = item;
            }
        }
    }
}
