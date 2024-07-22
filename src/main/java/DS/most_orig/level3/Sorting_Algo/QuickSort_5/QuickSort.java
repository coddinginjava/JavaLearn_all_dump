package DS.most_orig.level3.Sorting_Algo.QuickSort_5;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {

        if (start >= end)
            return;

        int boundary = getBoundary(array, start, end);

        sort(array, start, boundary - 1);
        sort(array, boundary + 1, end);

    }

    private int getBoundary(int[] array, int start, int end) {
        int pivot = array[end];
        int boundry = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot)
                swap(array, i, ++boundry);
        }
        return boundry;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
