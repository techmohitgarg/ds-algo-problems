package com.mohit.cses.dynamic_programming;

import java.util.Scanner;

public class GridsPaths {

    public static void main(String[] args) {
        GridsPaths paths = new GridsPaths();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String c = sc.next();
            char[] ch = c.toCharArray();
            for (int j = 0; j < ch.length; j++) {
                grid[i][j] = ch[j];
            }
        }

        System.out.println(paths.gridsPaths(n, grid));
    }


    private int gridsPaths(int n, char[][] digits) {

        if (n == 0) return 0;

        if (digits[n - 1][n - 1] == '*' || digits[0][0] == '*') return 0;

        int[][] dp = new int[n][n];


        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (digits[i][j] == '*') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = ((i > 0 ? dp[i - 1][j] % (int) (1e9 + 7) : 0) + (j > 0 ? dp[i][j - 1] % (int) (1e9 + 7) : 0)) % (int) (1e9 + 7);
                }
            }
        }

        return dp[n - 1][n - 1];
    }
}
