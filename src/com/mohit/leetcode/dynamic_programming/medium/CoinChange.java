package com.mohit.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        System.out.println(sol.coinChange(new int[]{0, 2, 5}, 3));
    }


    public int coinChange(int[] coins, int amount) {
        int[] num = new int[amount + 1];
        Arrays.fill(num, amount + 1);
        num[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount + 1; j++) {
                num[j] = Math.min(num[j], 1 + num[j - coins[i]]);
            }
        }
        return num[amount] > amount ? -1 : num[amount];
    }

    public int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }

        }
        return dp[n][W];
    }


}

