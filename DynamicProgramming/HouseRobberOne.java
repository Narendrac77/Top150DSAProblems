package DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber/description/
public class HouseRobberOne {
    public static void main(String[] args) {
        // int nums[] = { 1, 2, 3, 1 };
       //int nums[] = { 2, 7, 9, 3, 1 };
        int nums[] = { 1, 2, 1, 4};
        rob(nums);
    }

    public static void rob(int nums[]) {
        int n = nums.length;
        System.out.println("Recursive approach : " + recursiveApproach(n - 1, nums));
        System.out.println("Memoisation approach : " + dpApproach(n, nums));
        System.out.println("Tabulation approach : " + tabulation(n, nums));
        System.out.println("Space Optimization : " + spaceOptimization(n, nums));
    }

    public static int spaceOptimization(int n, int nums[]){
        int previous = nums[0];
        int previous_2 = 0;

        for(int i = 1; i < n; i++){
            int dontRob = previous;
            int rob = nums[i];
            if(i > 1){
                rob = nums[i] + previous_2;
            }
            int current = Math.max(dontRob, rob);

            previous_2 = previous;
            previous = current;
        }
        return previous;
    }

    public static int tabulation(int n, int nums[]){
        int dp[] = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            int dontRob = dp[i - 1];
            int rob = nums[i];
            if(i > 1){
                rob = nums[i] + dp[ i - 2];
            }   
            dp[i] = Math.max(rob, dontRob);
        } 
        return dp[n - 1];
    }

    public static int dpApproach(int n, int nums[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return memoisation(n - 1, nums, dp);
    }

    public static int memoisation(int idx, int nums[], int dp[]) {
        if (idx == 0)
            return nums[0];
        if (dp[idx] != -1)
            return dp[idx];

        int dontRob = memoisation(idx - 1, nums, dp);
        int rob = nums[idx];
        if (idx > 1) {
            rob = rob + memoisation(idx - 2, nums, dp);
        }
        return dp[idx] = Math.max(rob, dontRob);
    }

    public static int recursiveApproach(int idx, int nums[]) {
        if (idx == 0)
            return nums[0];
        int dontRob = recursiveApproach(idx - 1, nums);
        int rob = nums[idx];
        if (idx > 1) {
            rob = rob + recursiveApproach(idx - 2, nums);
        }
        return Math.max(dontRob, rob);
    }
}
