package com.mohit.leetcode.array.medium;

/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {
    public static void main(String[] args) {
        UniquePathsII pathsII = new UniquePathsII();
        System.out.println(pathsII.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 0, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        int[] paths = new int[obstacleGrid[0].length];
        paths[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[j] = 0;
                } else if (j > 0) {
                    paths[j] = paths[j - 1] + paths[j];
                }

            }
        }
        return paths[obstacleGrid[0].length - 1];
    }

    // Solution Without memory o(1) Space
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
