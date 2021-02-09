package com.mohit.cses.dynamic_programming;

import java.util.Scanner;

public class DiceCombinations {

    int MOD = 1000000007;

    public static void main(String[] args) {
        DiceCombinations combinations = new DiceCombinations();

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result = combinations.diceCombinations(num);
        System.out.println(result);
    }

    public int diceCombinations(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (j > i) break;
                dp[i] = (dp[i] % MOD + dp[i - j] % MOD) % MOD;
            }
        }


        return dp[n];
    }

}
