package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Twosum {

    public static void main(String[] args) {

//        int[] nums = new int[]{2,7,11,15};// should  return [0, 1] target 9
        int[] nums= new int []{-1,-2,-3,-4,-5}; // should return [2,4] target  -8

        int[] result = twoSum(nums,-8);
        System.out.println(Arrays.toString(result));


    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length ; i++){
            if(map.containsKey(nums[i])){
                return new int[]{ map.get(nums[i]), i};
            }else {
                map.put(target-nums[i],i);
            }
        }

        return  new int[]{};
    }



}
