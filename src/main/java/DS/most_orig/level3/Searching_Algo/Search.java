package DS.most_orig.level3.Searching_Algo;

public class Search {

    public int linearSearch(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item)
                return i;
        }
        return -1;
    }

    public int binarySearchRec(int[] array, int item) {
        return binarySearchRec(array, item, 0, array.length - 1);
    }

    private int binarySearchRec(int[] array, int target, int left, int right) {

        if (right < left)
            return -1;

        int middle = left + (right-left)/ 2;

        if (array[middle] == target) {
            return middle;
        }

        if (target > array[middle])
            return binarySearchRec(array, target, middle + 1, right);

        else
            return binarySearchRec(array, target, left, middle - 1);
    }

    public int binarySeacrhItr(int[] array, int item) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;

            if (array[middle] == item)
                return middle;

            if (item > array[middle])
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
    }

    public int ternarySearch(int[] array, int item) {
        return ternarySearch(array, item, 0, array.length - 1);
    }

    private int ternarySearch(int[] array, int target, int left, int right) {
        if (left >= right)
            return -1;
        int part = (right - left) / 3;
        int mid1 = left + part;
        int mid2 = right - part;

        if (array[mid1] == target)
            return mid1;
        if (array[mid2] == target)
            return mid2;

        if (target < array[mid1])
            return ternarySearch(array, target, left, mid1 - 1);
        if (target > array[mid2])
            return ternarySearch(array, target, mid2 + 1, right);

        return ternarySearch(array, target, mid1 + 1, mid2 - 1);
    }


    public int jumpsearch(int[] array, int item) {
        int bound = (int) Math.sqrt(array.length);
        int start = 0;
        int next = bound;

        while (start < array.length && array[next - 1] < item) {
            start = next;
            next += bound;
            if (next >= array.length)
                next = array.length;
        }

        for (int i = start; i < array.length; i++) {
            if (array[i] == item)
                return i;
        }
        return -1;
    }

    public int exponentialSearch(int[] array, int item) {
        int bound = 1;
        while (bound < array.length && array[bound] < item) {
            bound *= 2;
        }
        int left = bound / 2;
        int right = Math.min(bound, array.length - 1);
        return binarySearchRec(array, item, left, right);
    }
}
