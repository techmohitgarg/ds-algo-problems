package com.mohit.cses.dynamic_programming;

import java.util.Scanner;

public class CoinCombinationsII {

    int MOD = 1000000007;

    public static void main(String[] args) {
        CoinCombinationsII combinations = new CoinCombinationsII();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        long result = combinations.coinCombinations(coins, n, x);
        System.out.println(result);
    }

    public long coinCombinations(int[] coins, int n, int x) {
        if (n <= 0) return 0;
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= x; j++) {
                if (coins[i] > j)
                    continue;
                dp[j] = (dp[j] + dp[j - coins[i]]) % MOD;
            }
        }
        return dp[x] % MOD;
    }

}
