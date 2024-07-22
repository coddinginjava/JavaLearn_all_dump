package DS.most_orig.level3.Sorting_Algo.MergeSort_4;

public class MergerSort {

    public void sort(int array[]) {

        if (array.length < 2) // since its length 1,2,3 not 0,1,2
            return; //base condition terminal

        int midIndex = array.length / 2;

        int[] left = new int[midIndex];
        int[] right = new int[array.length - midIndex];

        for (int i = 0; i < midIndex; i++)
            left[i] = array[i];

        for (int i = midIndex; i < array.length; i++)
            right[i - midIndex] = array[i];

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }

}
