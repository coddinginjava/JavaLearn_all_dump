package LeetCode;

public class BuyandSellStock121 {

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
//        int[] arr = new int[]{7,6,4,3,1};
        System.out.println(maxProfit(arr));
    }


    public static  int maxProfit(int[] prices) {
        int sellOne = 0;
        int holdOne = Integer.MIN_VALUE;

        for (final int price : prices) {
            sellOne = Math.max(sellOne, holdOne + price);
            holdOne = Math.max(holdOne, -price);
        }

        return sellOne;
    }

}
