package com.mohit.cses.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class CoinCombinationsI {

    int MOD = 1000000007;// some this MOD value does not works so use this "(int) (1e9 + 7)"

    public static void main(String[] args) {
        CoinCombinationsI combinations = new CoinCombinationsI();

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
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) continue;
                dp[i] = (dp[i] + dp[i - coins[j]]) % (int) (1e9 + 7);
            }
        }
        return dp[x];
    }

}
