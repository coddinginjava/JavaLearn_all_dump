package CodingProbs;

import java.util.Arrays;

public class FindTheLongestSubArrayBySum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int targetSum = 21;

        int[] result = findTheLongestSubArrayBySum(arr, targetSum);

        System.out.println(Arrays.toString(result));
    }

    private static int[] findTheLongestSubArrayBySum(int[] arr, int s) {
        int[] result = new int[2];

        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < arr.length) {
            sum = sum + arr[right++];

            if(left<right && sum > s){
                sum = sum - arr[left++];
            }

            if(sum==s && ((result[1]-result[0])<((right-1)-left))){
                result = new int[]{left,right-1};
            }
        }

        return result;
    }
}
