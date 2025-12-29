package DynamicProgramming.knapsackProblems.UnboundedKnapsackProblems;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/description/
public class CoinChange {
    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        int amount = 11;
        coinChange(coins, amount);
    }

    public static void coinChange(int coins[], int amount) {
        int recursiveResult = recursiveApproach(coins.length - 1, coins, amount);
        if (recursiveResult >= (int) Math.pow(10, 9)) {
            System.out.println(-1);
        } else {
            System.out.println("Recursive approach result : " + recursiveResult);
        }
        int dpApproachResult = dpApproach(coins.length - 1, coins, amount);
        if (dpApproachResult >= (int) Math.pow(10, 9)) {
            System.out.println(-1);
        } else {
            System.out.println("Dp Approach result " + dpApproachResult);
        }
        int tabulationApproach = tabulationApproach(coins, amount);
        System.out.println("Tabulation approch " + tabulationApproach);

        int spaceOptimized = spaceOptimized(coins, amount);
        System.out.println("Space optimised " + spaceOptimized);
    }

    public static int spaceOptimized(int coins[], int amount){
        int INF = (int) Math.pow(10, 9);

        int dp[] = new int[amount + 1];

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for(int coin : coins){
            for(int a = coin ; a <= amount; a++){
                dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
            }
        }
        return dp[amount] >= INF ? -1 : dp[amount];
    }

    public static int tabulationApproach(int coins[], int amount){
        int n = coins.length;

        int dp[][] = new int[n][amount + 1];

        //Base case : Using only coin[0];
        for(int a = 0; a <= amount; a++){
            if(a % coins[0] == 0){
                dp[0][a] = a / coins[0];
            } else {
                dp[0][a] = (int) Math.pow(10, 9);
            }
        }

        //Fill DP table
        for(int i = 1; i < n; i++){
            for( int a = 0; a <= amount; a++){
                int notTake = dp[i - 1][a];
                int take = (int) Math.pow(10,9);
                if(coins[i] <= a){
                    take = 1 + dp[i][a - coins[i]];
                }

                dp[i][a] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        return ans >= (int) Math.pow(10, 9) ? -1 : ans;
    }

    public static int dpApproach(int idx, int coins[], int amount) {
        int dp[][] = new int[coins.length][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memoisation(idx, coins, amount, dp);
    }

    public static int memoisation(int idx, int coins[], int amount, int dp[][]) {
        if (idx == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int) Math.pow(10, 9);
        }

        if (dp[idx][amount] != -1)
            return dp[idx][amount];

        int notTake = memoisation(idx - 1, coins, amount, dp);

        int take = (int) Math.pow(10, 9);

        if (coins[idx] <= amount) {
            take = 1 + memoisation(idx, coins, amount - coins[idx], dp);
        }

        return dp[idx][amount] = Math.min(take, notTake);
    }

    public static int recursiveApproach(int idx, int coins[], int amount) {
        if (idx == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int) Math.pow(10, 9);
        }

        int notTake = recursiveApproach(idx - 1, coins, amount);

        int take = (int) Math.pow(10, 9);

        if (coins[idx] <= amount) {
            take = 1 + recursiveApproach(idx, coins, amount - coins[idx]);
        }

        return Math.min(take, notTake);
    }
}
