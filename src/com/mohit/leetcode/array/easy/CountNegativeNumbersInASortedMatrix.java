package com.mohit.leetcode.array.easy;

public class CountNegativeNumbersInASortedMatrix {


    public int countNegatives(int[][] grid) {
        int result = 0;

        // Base case
        if (grid.length == 0) return result;

        int i = grid.length - 1;
        int j = grid[i].length - 1;

        while (i >= 0 && j >= 0) {
            // check if number is negative or not
            if (grid[i][j] < 0) {
                result++;
            }

            if (j == 0 || grid[i][j] >= 0) {
                i--;
                j = (i < 0) ? -1 : grid[i].length - 1;
            } else {
                j--;
            }
        }

        return result;
    }
}
