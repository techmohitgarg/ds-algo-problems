package com.mohit.leetcode.dynamic_programming.medium;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths paths = new UniquePaths();
        System.out.println(paths.uniquePaths(3, 7));
        System.out.println(paths.uniquePaths1(7, 3));

    }

    public int uniquePaths(int m, int n) {
        if (m == 0 && m == 0) {
            return 0;
        }
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[m - 1][n - 1];
    }

    public int uniquePaths1(int m, int n) {
        if (m == 0 && m == 0) {
            return 0;
        }
        int[] paths = new int[n];
        paths[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[j] = paths[j - 1] + paths[j];
            }
        }
        return paths[n - 1];
    }

    public int uniquePaths2(int m, int n) {
        if (m == 0 || m == 0) {
            return 1;
        }
        return uniquePaths2(m - 1, n) + uniquePaths2(m, n - 1);
    }

}
