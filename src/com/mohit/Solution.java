package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
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


    private int binomialCoeff(int n, int k) {
        if (k == 0 || k == n) return 1;
        return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
    }

    private int binomialCoefficientUsingDP(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }


    static int permutationCoeff(int n, int k) {
        if (k == 0 || k == n) return 1;
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        return fact[n] / fact[n - k];
    }

    static int permutationCoeff1(int n, int k) {
        if (k == 0 || k == n) return 1;
        int fact = 1;
        int num = n;
        while (num > (n - k)) {
            fact = fact * num;
            num--;
        }
        return fact;
    }

}

