package DS.most_orig.level3.Sorting_Algo.CountingSort_6;

public class CountingSort {

    public void sort(int[] array, int max) {

        int[] counts = new int[max + 1];

        for (int i : array) {
            counts[i]++;
        }

        int k = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }
    }

}
