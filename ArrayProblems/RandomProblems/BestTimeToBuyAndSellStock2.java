package ArrayProblems.RandomProblems;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class BestTimeToBuyAndSellStock2 {
    public static void main(String[] args) {
        int prices[] = { 7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int nums[]){
        int maxProfit = 0;
        for(int i = 0; i < nums.length - 1;i++){
            if(nums[i] < nums[i + 1]) maxProfit = maxProfit + nums[i + 1] - nums[i];
        }

        return maxProfit;
    }
}
