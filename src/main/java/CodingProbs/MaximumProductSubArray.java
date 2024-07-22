package CodingProbs;

import java.util.Arrays;

public class MaximumProductSubArray {
    public static void main(String[] args) {
//        int[] arr = new int[]{2,3,-2,4};//6
//        int[] arr = new int[]{-2,0,-1};//0
        int[] arr = new int[]{-5, 3, 1, -2, -1, 7};
        /* -5
           -15
           -15
           30
           -30
           -210

           3
           3
           -6
           6
           42

           1
           -2
           2
           14

           -2
           2
           14

           -1
           -7

           7

        * */
        int finalResult = getMaximumProductSubArray(arr);

        System.out.println("finalResult = " + finalResult);
    }

    private static int getMaximumProductSubArray(int[] arr) {
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i - 1] * arr[i]);
            result = Math.max(result, arr[i]);
        }

        System.out.println(Arrays.toString(arr));

        return result;
    }
}
