package LeetCode;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {

        int[] nums = new int[]{2,0,2,1,1,0};


        System.out.println(Arrays.toString(sortColors(nums)));
    }

    public static  int[]  sortColors(int[] nums) {
        int[] arr= new int[nums.length];
        int i =0 , j = nums.length-1;
        for(int num : nums){
            if(num==0){
                arr[i++]=0;
            }
            if(num==2){
                arr[j--]=2;
            }
        }
        while(i <= j){
            arr[i++] =1;
        }

        return  arr;
    }
}
