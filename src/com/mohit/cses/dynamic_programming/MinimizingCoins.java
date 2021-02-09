package com.mohit.cses.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizingCoins {

    public static void main(String[] args) {
        MinimizingCoins minimizingCoins = new MinimizingCoins();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        minimizingCoins.minimizingCoins(coins, x);


    }

    public void minimizingCoins(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    continue;
                }

                int sub_res = dp[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i])
                    dp[i] = sub_res + 1;
            }
        }
        if (dp[sum] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[sum]);
        }
    }


}
