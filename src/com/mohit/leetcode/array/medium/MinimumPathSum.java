package com.mohit.leetcode.array.medium;

/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum pathSum = new MinimumPathSum();
        System.out.println(pathSum.minPathSum(new int[][]{{1, 3}, {1, 5}}));
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] sum = new int[grid.length][grid[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                if (i == 0) {
                    sum[i][j] = (j == 0 ? grid[i][j] : grid[i][j] + sum[i][j - 1]);
                } else if (j == 0) {
                    sum[i][j] = (i == 0 ? grid[i][j] : grid[i][j] + sum[i - 1][j]);
                } else {
                    sum[i][j] = Math.min(sum[i - 1][j] + grid[i][j], sum[i][j - 1] + grid[i][j]);
                }

            }
        }
        return sum[grid.length - 1][grid[0].length - 1];
    }

    /*
     * More Solutions
    //
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    grid[i][j] = grid[i][j] + (j > 0 ? grid[i][j - 1] : 0);
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + (i > 0 ? grid[i - 1][j] : 0);
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }

            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
    */
}
