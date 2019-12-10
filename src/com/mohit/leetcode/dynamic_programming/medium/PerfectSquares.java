package com.mohit.leetcode.dynamic_programming.medium;

public class PerfectSquares {

    public static void main(String[] args) {
        System.out.print("---" + new PerfectSquares().numSquares_(4));
    }

    public int numSquares(int n) {
        if (n <= 3)
            return n;
        int res = n;
        for (int x = 1; x <= n; x++) {
            int temp = x * x;
            if (temp > n)
                break;
            else
                res = Math.min(res, 1 + numSquares(n - temp));

        }
        return res;
    }

    public int numSquares_(int n) {
        if (n <= 3)
            return n;

        // Base case
        int[] dp = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            dp[i] = i;
            for (int x = 1; x <= i; x++) {
                int temp = x * x;
                if (temp > i) {
                    break;
                } else {
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
                }
            }
        }
        return dp[n];
    }


}