package DS.most_orig.level3.Sorting_Algo.Bubble_Sort_1;

public class BubbleSort {

    public void sort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
//                System.out.println("comparing " + array[j] + " & " + array[j - 1]);
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    private void swap(int array[], int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
