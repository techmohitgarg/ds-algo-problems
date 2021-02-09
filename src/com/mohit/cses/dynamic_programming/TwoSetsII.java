package com.mohit.cses.dynamic_programming;

import java.util.Scanner;

public class TwoSetsII {
    int MOD = 1000000007;

    public static void main(String[] args) {
        TwoSetsII set = new TwoSetsII();
        TwoSetsII setsII = new TwoSetsII();
        Scanner sc = new Scanner(System.in);
        setsII.subSetsCount(sc);
    }

    private void subSetsCount(Scanner sc) {

        int n = sc.nextInt();

        int totalSum = (n * (n + 1)) / 2;

        if ((totalSum) % 2 != 0)
            System.out.println(0);
        else {
            long[][] dp = new long[n + 1][totalSum + 1];

            dp[0][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= totalSum / 2; j++) {
                    dp[i][j] = (((j < i) ? 0 : dp[i - 1][j - i]) + dp[i - 1][j]) % MOD;
                }
            }
            long result = (dp[n][totalSum / 2] * 500000004) % MOD;
            System.out.println(result);
        }
    }
}
