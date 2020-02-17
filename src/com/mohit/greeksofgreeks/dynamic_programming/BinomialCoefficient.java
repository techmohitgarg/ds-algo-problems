package com.mohit.greeksofgreeks.dynamic_programming;

public class BinomialCoefficient {
    public static void main(String[] args) {
        BinomialCoefficient coefficient = new BinomialCoefficient();

        coefficient.binomialCoefficientUsingDP(10, 3);
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
}
