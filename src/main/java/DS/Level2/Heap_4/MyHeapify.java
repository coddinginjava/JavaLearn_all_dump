package DS.Level2.Heap_4;

public class MyHeapify {

    public static void doHeap(int[] array) {
        int lastParent = (array.length - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            heapify(array, i);
        }

    }

    private static void heapify(int[] array, int index) {
        int largeIndex = index;
        int leftIndex = (index * 2) + 1;
        if (leftIndex < array.length && array[largeIndex] < array[leftIndex])
            largeIndex = leftIndex;

        int rightIndex = (index * 2) + 2;
        if (rightIndex < array.length && array[largeIndex] < array[rightIndex])
            largeIndex = rightIndex;

        if (index == largeIndex)
            return;

        sort(array, index, largeIndex);
        heapify(array, largeIndex);
    }

    private static void sort(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int getKthLargeritem(int[] arr, int k) {
        MyHeap heap = new MyHeap();
        for (int i : arr) {
            heap.insert(i);
        }

        for (int i = k - 1; i > 0; i--) {
            heap.remove();
        }

        return heap.getMax();
    }
}
