package DS.most_orig.level2.heap_3;

public class MyHeapify {


    public static void doHeapify(int[] arr) {
        int startIndex = (arr.length / 2) - 1;
        for (int i = startIndex; i >= 0; i--) {
            doHeapify(arr, i);
        }
    }

    private static void doHeapify(int[] arr, int index) {
        int largerIndex = index;

        int leftChildIndex = (largerIndex * 2) + 1;
        if (leftChildIndex < arr.length &&
                arr[leftChildIndex] > arr[largerIndex]) {
            swap(arr, largerIndex, leftChildIndex);
            largerIndex = leftChildIndex;
        }

        int rightChildIndex = (largerIndex * 2) + 2;
        if (rightChildIndex < arr.length &&
                arr[rightChildIndex] > arr[largerIndex]) {
            swap(arr, largerIndex, rightChildIndex);
            largerIndex = rightChildIndex;
        }

        if (index == largerIndex)
            return;

        doHeapify(arr, largerIndex);

    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static  int getKthLargeritem(int[] arr, int index) {
        if (index < 1 || index > arr.length)
            throw new IllegalStateException();

//        return -1;

        MyHeap heap = new MyHeap();
        for (int i : arr)
            heap.insert(i);

        for (int i = 0; i < index - 1; i++) {
            heap.remove();
        }
        return heap.getMax();

    }

}
