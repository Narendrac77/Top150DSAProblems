package DynamicProgramming.knapsackProblems;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/description/
public class PartitionEqualSubSetSum {
    public static void main(String[] args) {
        int nums[] = { 1, 5, 11, 5};
        //int nums[] =  { 1, 2, 3, 5};
        canPartition(nums);
        System.out.println(canPartitionLL(nums));
        System.out.println(canPartitionSpaceOptimization(nums));
    }

    public static void canPartition(int nums[]){
        int sum = 0;
        for(int val : nums){
            sum = sum + val;
        }

        if(sum % 2 != 0){
            System.out.println("Cannot be partitioned ");
            return;
        }
        
        boolean recursiveResult = recursiveApproach(nums.length - 1, nums, sum / 2);
        System.out.println( " recursive approach " + recursiveResult);

        boolean dpApproachResult = dpApproach(nums.length, nums, sum / 2);
        System.out.println(" dp Approach " + dpApproachResult);
    }

    public static boolean canPartitionSpaceOptimization(int nums[]){
        int sum = 0;
        for(int num : nums) sum += num;

        if(sum % 2 != 0) return false;

        int target = sum/ 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num : nums){
            for(int s = target; s >= num; s--){
                dp[s] = dp[s] || dp[s - num];
                if(s == target && dp[s] == true){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean tabulationApproach(int n, int nums[], int target){
        boolean dp[][] = new boolean[n][target + 1];

        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }

        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i = 1; i < n; i++){
            for(int s = 1; s <= target; s++){
                boolean notTake = dp[i - 1][s];
                boolean take = false;
                if(nums[i] <= s){
                    take = dp[i - 1][s - nums[i]];
                }

                dp[i][s] = notTake || take;
            }
        }

        return dp[n - 1][target];
    }


    public static boolean dpApproach(int idx, int nums[], int target){
        int dp[][] = new int[idx + 1][target + 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return memoisation(idx - 1, nums, target, dp);
    }

    public static boolean memoisation(int idx, int nums[], int target, int dp[][]){
        if(target == 0) return true;
        if(idx == 0) return nums[0] == target;

        if(dp[idx][target] != -1) return dp[idx][target] == 0 ? true : false;

        boolean notTake = memoisation(idx - 1, nums, target, dp);
        boolean take = false;
        if(nums[idx] <= target){
        take = memoisation(idx - 1, nums, target - nums[idx], dp);
        }

        dp[idx][target] = (take || notTake) == true ? 0 : 1;
        return take || notTake;

    }

    public static boolean recursiveApproach(int idx, int nums[],int target){
        if(target == 0) return true;
        if(idx == 0) return nums[0] == target;

        boolean notPick = recursiveApproach(idx - 1, nums, target);
        boolean pick = false;
        if(nums[idx] <= target){
        pick = recursiveApproach(idx - 1, nums, target - nums[idx]);
        }
        return pick || notPick;

    }


    public static boolean canPartitionLL(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for(int num : nums){
            sum = sum + num;
        }

        if(sum % 2 != 0) return false;

        int dp[][] = new int[n + 1][ (sum / 2 )+ 1];

        for(int[] val : dp){
            Arrays.fill(val, -1);
        }

        return memoization(n - 1, nums, sum / 2, dp);
        
    }

    public static boolean memoization(int idx, int nums[], int target, int dp[][]){
        if(target == 0) return true;
        if(idx == 0) return nums[0] == target;

        if(dp[idx][target] != -1) return dp[idx][target] == 0 ? true : false;

        boolean notTake = memoization(idx - 1, nums, target, dp);
        boolean take = false;
        if(nums[idx] <= target){
        take = memoization(idx - 1, nums, target - nums[idx], dp);
        }

        dp[idx][target] = notTake || take == true ? 0 : 1;

        return notTake || take;
    }
}
