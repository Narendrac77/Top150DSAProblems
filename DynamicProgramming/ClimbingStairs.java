package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
      int n = 5;
      climbStairs(n);
    }

    public static void climbStairs(int n){
        System.out.println("recursive approach : " + recursiveApproach(n));
        System.out.println("memoisation approach : " + dpApproach(n));
        System.out.println("Tabulation approach : " + tabulation(n));
        System.out.println("Space optimization : " + spaceOptimization(n));
    }

    public static int tabulation(int n){
        if(n < 2) return 1;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    public static int dpApproach(int n){
        int dp[] = new int[n + 1];
        Arrays.fill(dp, - 1);
        return memoisation(n, dp);
    }

    public static int memoisation(int n, int dp[]){
        if(n < 2) return 1;
        if(dp[n] != -1) return dp[n];
        dp[n] = memoisation(n - 1, dp) + memoisation(n - 2, dp);
        return dp[n];
    }

    public static int recursiveApproach(int n){
        if(n < 2) return 1;
        return recursiveApproach(n - 1) + recursiveApproach( n - 2);
    }

    public static int spaceOptimization(int n){
        if(n < 2) return 1;

        int previous = 1, previous_2 = 1;

        int i = 2;

        while( i <= n){
            int current = previous + previous_2;
            previous_2 = previous;
            previous = current;
            i++;
        }
        return previous;
    }
}
