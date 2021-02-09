package com.mohit.cses.dynamic_programming;

import java.util.Scanner;

public class ArrayDescription {
    public static void main(String[] args) {
        ArrayDescription description = new ArrayDescription();
        Scanner sc = new Scanner(System.in);
        description.arrayDescription(sc);

    }

    int MOD = 1000000007;

    private int arrayDescription(Scanner sc) {

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long[][] dp = new long[m + 1][n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] != 0)
                    dp[arr[i]][i] = 1;
                else {
                    for (int j = 1; j <= m; j++) {
                        dp[j][i] = 1;
                    }
                }
                continue;
            }

            if (arr[i] != 0) {
                dp[arr[i]][i] = dp[arr[i] - 1][i - 1] +
                        dp[arr[i]][i - 1] +
                        ((arr[i] + 1 <= m) ? dp[arr[i] + 1][i - 1] : 0);
                dp[arr[i]][i] = dp[arr[i]][i] % MOD;
            } else {
                for (int j = 1; j <= m; j++) {
                    dp[j][i] = dp[j - 1][i - 1];
                    dp[j][i] = dp[j][i] + dp[j][i - 1];
                    if (j < m) dp[j][i] = dp[j][i] + dp[j + 1][i - 1];
                    dp[j][i] %= MOD;
                }
            }
        }
        if (arr[n - 1] != 0) {
            System.out.println(dp[arr[n - 1]][n - 1]);
        } else {
            long result = 0;
            for (int i = 1; i <= m; i++) {
                result = (result + dp[i][n - 1]);
                result = result % MOD;
            }
            System.out.println(result);
        }

        return 0;

    }
}
