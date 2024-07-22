package DS.most_orig.level3.Sorting_Algo.Selection_Sort_2;

public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if(array[j]<array[minIndex])
                    minIndex=j;
            }
            swap(array,i,minIndex);
        }
    }

    private void swap(int[] array, int i, int minIndex) {
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
