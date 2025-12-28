package DynamicProgramming;

public class MaximumSubArray {
    public static void main(String[] args) {
        int nums[] = { -1, -2, 3, -2, 4 };
        System.out.println(maxSubArraySum(nums));
    }

    public static int spaceOptimization(int nums[]){
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    public static int maxSubArraySum(int nums[]) {
        int n = nums.length;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
