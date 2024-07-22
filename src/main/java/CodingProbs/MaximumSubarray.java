package CodingProbs;

import java.util.Arrays;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = getMaximumContigousSubArray(arr);

        System.out.println("result = " + result);
    }

    private static int getMaximumContigousSubArray(int[] arr) {
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1] + arr[i]);
            result = Math.max(result, arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        return result;
    }
}
