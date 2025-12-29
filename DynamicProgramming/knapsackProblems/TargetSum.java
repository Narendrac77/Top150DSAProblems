package DynamicProgramming.knapsackProblems;

import java.util.Arrays;

//https://leetcode.com/problems/target-sum/description/
public class TargetSum {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 1, 1 };
        int target = 3;
        findTargetSumWays(nums, target);
    }

    public static void findTargetSumWays(int nums[], int target) {
        int recursiveResult = recursiveApproach(nums.length - 1, nums, target, 0);
        System.out.println(dfs(0, 0, nums, target));
        System.out.println("Recursive approach soultion " + recursiveResult);
       // int dpApproach = dpApproach(nums.length - 1, nums, target, 0);
       // System.out.println("DP Approach " + dpApproach);
       int spaceOptimizedApproach = spaceOptimized(nums, target);
       System.out.println("Space optimsed solutin " + spaceOptimizedApproach);
    }

    public static int spaceOptimized(int[] nums, int target){
        int totalSum = 0;

        for(int num : nums) totalSum = totalSum + num;

        //Impossible cases
        if(totalSum < Math.abs(target)) return 0;
        if((totalSum + target) % 2 != 0) return 0;

        int Sum = (totalSum + target) / 2;

        int dp[] = new int[Sum + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int s = Sum; s >= num; s--){
                dp[s] = dp[s] + dp[s - num];
            }
        }
        return dp[Sum];
    }

    // current dp implementation will not work.
   /* public static int dpApproach(int idx, int nums[], int target, int currentSum){
        int dp[][] = new int[nums.length][target + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return memoization(idx, nums, target, currentSum, dp);
    }

    public static int memoization(int idx, int nums[], int target, int currentSum, int dp[][]){
        if(idx < 0) return target == currentSum ? 1 : 0;

        if(dp[idx][currentSum] != -1) return dp[idx][currentSum];

        int add = memoization(idx - 1, nums, target, currentSum + nums[idx], dp);
        int subtract = memoization(idx - 1, nums, target, currentSum - nums[idx], dp);

        return dp[idx][currentSum] = add + subtract;
    } */

    //Top down recursive approach
    public static int recursiveApproach(int idx, int nums[], int target, int currentSum) {
        // if(idx < 0) return 0;
        if (idx < 0)
            return currentSum == target ? 1 : 0;

        int add = recursiveApproach(idx - 1, nums, target, currentSum + nums[idx]);
        int subtract = recursiveApproach(idx - 1, nums, target, currentSum - nums[idx]);

        return add + subtract;
    }

    //bottom up recursive approach
    private static int dfs(int idx, int currentSum, int[] nums, int target) {
        // Base case: all elements used
        if (idx == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        // Choose + or -
        int add = dfs(idx + 1, currentSum + nums[idx], nums, target);
        int subtract = dfs(idx + 1, currentSum - nums[idx], nums, target);

        return add + subtract;
    }
}
