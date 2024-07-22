package LeetCode;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
//        int[] nums = new int[]{0,1,0,3,12}; // expected Output: [1,3,12,0,0]
        int[] nums = new int[]{0}; //expected [0]

        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));


    }


    public static  void moveZeroes(int[] nums) {

        int count  =0 ;

        for(int num : nums){
            if(num!=0)
                nums[count++] = num;
        }


        while(count<nums.length)
            nums[count++] = 0;

    }
}
