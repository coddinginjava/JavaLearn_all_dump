package DS.Level3;

public class Search {

    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public int binarySearchRec(int[] arr, int target) {
        return binarySearchRec(arr, target, 0, arr.length - 1);
    }

    private int binarySearchRec(int[] arr, int target, int left, int right) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (target == arr[mid])
            return mid;

        if (target > arr[mid])
            return binarySearchRec(arr, target, mid + 1, right);
        else
            return binarySearchRec(arr, target, left, mid - 1);
    }

    public int binarySeacrhItr(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (target == arr[mid])
                return mid;
            if (target > arr[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
