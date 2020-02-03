package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 11));
    }


    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        if (coins.length == 1 && coins[0] > amount) return -1;
        int[][] num = new int[coins.length + 1][amount + 1];
        // Base case (If given value is 0)
        for (int i = 0; i <= coins.length; i++) {
            num[0][i] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    num[i][j] = num[i - 1][j];
                } else {
                    num[i][j] = num[i - 1][j] + num[i][j - coins[i - 1]];
                }
            }
        }
        return num[coins.length][amount] == 0 ? -1 : num[coins.length][amount];
    }

    public int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
                }
            }

        }
        return dp[n][W];
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] square = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    square[i][j] = matrix[i][j] - '0';
                } else if (matrix[i][j] == '0') {
                    square[i][j] = 0;
                } else {
                    square[i][j] = 1 + Math.min(square[i - 1][j - 1], Math.min(square[i - 1][j], square[i][j - 1]));
                }
                max = Math.max(max, square[i][j]);
            }
        }
        return max * max;
    }

    public int rob(int[] nums) {
        // Base cases
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] start_from_root = new int[nums.length];
        int[] start_from__after_root = new int[nums.length];

        start_from_root[0] = nums[0];
        start_from_root[1] = Math.max(nums[0], nums[1]);

        start_from__after_root[0] = 0;
        start_from__after_root[1] = nums[1];
        for (int i = 2; i < nums.length - 1; i++) {
            start_from_root[i] = Math.max(start_from_root[i - 1], nums[i] + start_from_root[i - 2]);
            start_from__after_root[i] = Math.max(start_from__after_root[i - 1], nums[i] + start_from__after_root[i - 2]);
        }
        return Math.max(start_from_root[nums.length - 2], start_from__after_root[nums.length - 1]);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int currentMax = nums[0];
        int currentMin = currentMax;
        int max = currentMax;
        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;
            currentMax = Math.max(nums[i], Math.max(nums[i] * currentMin, nums[i] * currentMax));
            currentMin = Math.min(currentMin, Math.min(nums[i] * currentMin, nums[i] * temp));
            max = Math.max(max, currentMax);
        }
        return max;
    }


}

