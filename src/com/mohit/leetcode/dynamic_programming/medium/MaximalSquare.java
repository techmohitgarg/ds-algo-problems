package com.mohit.leetcode.dynamic_programming.medium;

public class MaximalSquare {

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[][] sum = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char c = matrix[i][j];
                if (i == 0 || j == 0) {
                    sum[i][j] = (c - '0');
                } else if (matrix[i][j] == '1') {
                    sum[i][j] = 1 + Math.min(sum[i - 1][j], Math.min(sum[i][j - 1], sum[i - 1][j - 1]));
                } else {
                    sum[i][j] = 0;
                }
                max = Math.max(max, sum[i][j]);
            }
        }
        return max * max;
    }

}