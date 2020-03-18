package com.mohit.leetcode.dynamic_programming.medium;

public class CountSquareSubmatriceswithAllOnes {

    public static void main(String[] args) {
        CountSquareSubmatriceswithAllOnes sol = new CountSquareSubmatriceswithAllOnes();
        System.out.printf(String.valueOf(sol.countSquares(new int[][]{{0,0,1}, {1,1,0}, {1,1,0}})));
    }

    public int countSquares(int[][] matrix) {

        // Base Case
        if (matrix.length == 0) return 0;

        int total = 0;
        int[][] sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        sum[i][j] = matrix[i][j];
                        total += sum[i][j];
                    } else {
                        sum[i][j] = 1 + Math.min(sum[i - 1][j - 1], Math.min(sum[i][j - 1], sum[i - 1][j]));
                        total += sum[i][j];
                    }
                }
            }
        }
        return total;

        /**
         * Tc : o(n*n)
         * SC : o(n*n)
         */
    }
}

