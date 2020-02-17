package com.mohit.greeksofgreeks.dynamic_programming;

public class CoinChangesProblems {

    public static void main(String[] args) {
        CoinChangesProblems sol = new CoinChangesProblems();
        System.out.println(sol.getCoinChange(new int[]{2, 5, 3, 6}, 10));
    }


    private int getCoinChange(int[] coins, int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[n];
    }
}
