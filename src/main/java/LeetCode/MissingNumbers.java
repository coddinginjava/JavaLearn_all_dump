package LeetCode;

public class MissingNumbers {

    public static void main(String[] args) {
        int[] nums = new int[]{9,6,4,2,3,5,7,0,1}; // expected  8

          System.out.println(missingNumber(nums));

    }

    public static int missingNumber(int[] nums) {

        int ans = nums.length;

        for (int i = 0; i < nums.length; ++i){
            int in = i ^ nums[i];
            ans = ans ^ in;
        }


        return ans;


    }
}
