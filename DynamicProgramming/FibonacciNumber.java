package DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/fibonacci-number/description/
public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 10;
        fin(n);
    }

    public static void fin(int n) {
        System.out.println("recursive solution is :  " + recursion(n));
        System.out.println("Memoization approach is : " + dpApproach(n));
         System.out.println("tabulation approach is : " + tabulationApproach(n));
         System.out.println("space Optimisation is : " + spaceOptimization(n));
    }

    public static int spaceOptimization(int n){
        int prev2 = 0, prev = 1;

        for(int i = 2; i <= n; i++){
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static int tabulationApproach(int n){
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        } 
        return dp[n];
    }

    public static int dpApproach(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoisation(n, dp);
    }

    public static int memoisation(int n, int dp[]) {
        if (n < 2)
            return n;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = memoisation(n - 1, dp) + memoisation(n - 2, dp);
        return dp[n];
    }

    public static int recursion(int n) {
        if (n < 2)
            return n;

        return recursion(n - 1) + recursion(n - 2);
    }
}
