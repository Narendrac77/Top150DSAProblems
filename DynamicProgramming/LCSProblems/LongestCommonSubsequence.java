package DynamicProgramming.LCSProblems;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-subsequence/description/
public class LongestCommonSubsequence {
  
    public static void main(String[] args) {
        String text1 = " abcde", text2 = "ace";
        longestCommonSubsequence(text1, text2);
    }


    public static void longestCommonSubsequence(String text1, String text2){
        int recursiveResult = recursiveApproach(text1, text2, text1.length() - 1, text2.length() - 1);
        System.out.println("recursive approach " + recursiveResult);
        int dpApproachResult = dpApproach(text1, text2);
        System.out.println("DP Approach " + dpApproachResult);

        int tabulationApproach = tabulation(text1, text2);
        System.out.println("Tabulation apprach " + tabulationApproach);
    }

    public static int tabulation(String text1, String text2){
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                 } else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                 }
            }
        }
        return dp[m][n];
    }

    public static int dpApproach(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, - 1);
        }
       return memoisation(text1, text2, text1.length() - 1, text2.length() - 1, dp); 
    }

    public static int memoisation(String text1, String text2, int l1, int l2,int dp[][]){
        if(l1 < 0 || l2 < 0){
            return 0;
        }

        if(dp[l1][l2] != -1) return dp[l1][l2];

        if(text1.charAt(l1) == text2.charAt(l2)){
            dp[l1][l2] = 1 + memoisation(text1, text2, l1 - 1, l2 - 1, dp);
        }

        else{ 
            dp[l1][l2] = Math.max(memoisation(text1, text2, l1 - 1, l2, dp), 
                                memoisation(text1, text2, l1, l2 - 1, dp));
        }

        return dp[l1][l2];
    }

    public static int recursiveApproach(String text1, String text2, int l1, int l2){
        if(l1 < 0 || l2 < 0) return 0;

        if(text1.charAt(l1) == text2.charAt(l2)){
            return 1 + recursiveApproach(text1, text2, l1 - 1, l2 - 1);
        }

        return Math.max(recursiveApproach(text1, text2, l1 -1 , l2), recursiveApproach(text1, text2, l1, l2 - 1));
    }
}
