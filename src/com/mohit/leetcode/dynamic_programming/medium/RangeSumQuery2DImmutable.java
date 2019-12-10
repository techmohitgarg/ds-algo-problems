package com.mohit.leetcode.dynamic_programming.medium;

public class RangeSumQuery2DImmutable {
    //https://leetcode.com/problems/range-sum-query-2d-immutable/solution/
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);

        print(obj.sumRegion(2, 1, 4, 3)); //-> 8
        print(obj.sumRegion(1, 1, 2, 2)); //-> 11
        print(obj.sumRegion(1, 2, 2, 4)); //-> 12
    }

    private static void print(int val) {
        System.out.println(val);
    }

    static class NumMatrix {

        int[][] sumOfRow = null;

        public NumMatrix(int[][] matrix) {
            if (matrix.length > 0) {
                sumOfRow = new int[matrix.length][matrix[0].length + 1];
                // Calculate the sum for all the row's
                for (int i = 0; i < matrix.length; i++) {
                    int[] rows = matrix[i];
                    // Start the loop for row
                    for (int j = 0; j < rows.length; j++) {
                        sumOfRow[i][j + 1] = sumOfRow[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // Calculate the sum
            int totalSum = 0;
            for (int i = row1; i <= row2; i++) {
                totalSum += sumOfRow[i][col2 + 1] - sumOfRow[i][col1];
            }
            return totalSum;
        }
    }
}