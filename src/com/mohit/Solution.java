package com.mohit;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int m = 7;
        int n = 3;
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}}));
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] uniquePath = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    uniquePath[j] = 1;
                } else {
                    uniquePath[j] += uniquePath[j - 1];
                }
            }
        }
        return uniquePath[n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = (i > 0 ? obstacleGrid[i - 1][j] : 0) + (j > 0 ? obstacleGrid[i][j - 1] : 0);
                }
            }

        }
        return obstacleGrid[m - 1][n - 1];
    }
}
