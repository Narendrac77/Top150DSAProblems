package DynamicProgramming;

import java.util.Arrays;

public class MinCostClimingStairs {
    public static void main(String[] args) {
       // int cost[] = { 10, 15, 20};
       int cost[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostClimbingStairs(cost);
    }

    public static void minCostClimbingStairs(int cost[]){
        int n = cost.length;
        System.out.println("recursive approach : " + Math.min(recursiveApproach(n - 1, cost), recursiveApproach(n - 2, cost)));
        System.out.println("dp Approach  : " + dpApproach(cost, n));
        System.out.println("tabulation approach : " + tabulationApproach(n, cost));
        System.out.println("Space optimization : " + spaceOptimization(n, cost));
    }

    public static int spaceOptimization(int n, int cost[]){
        if(cost.length == 1) return cost[0];
        int step1 = cost[0];
        int step2 = cost[1];

        for(int i = 2; i < cost.length; i++){
            int current = cost[i] + Math.min(step1, step2);
            step1 = step2;
            step2 = current;
        }
        return Math.min(step1, step2);
    }

    public static int tabulationApproach(int n, int cost[]){
        if(cost.length < 2) return cost[0];
        int dp[] = new int[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++){
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n-1], dp[n - 2]);
    }

    public static int dpApproach(int cost[], int n){
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(memoisation(n - 1, cost, dp), memoisation(n - 2, cost, dp));
    }

     public static int memoisation(int idx, int cost[], int dp[]){
       if(idx < 0) return 0;
       if(idx == 0) return cost[0];
       if(dp[idx] != -1) return dp[idx];
       int step2 = memoisation(idx - 2, cost, dp);
       int step1 = memoisation(idx - 1, cost, dp);
       return dp[idx] = cost[idx] + Math.min(step2, step1);
     }

    public static int recursiveApproach(int idx, int cost[]){
        if(idx == 0) return cost[0];
        if(idx < 0 ) return 0;
        int step2 = recursiveApproach(idx - 2, cost);
        int step1 = recursiveApproach(idx - 1, cost);
        return cost[idx] + Math.min(step1, step2);
    }
}
