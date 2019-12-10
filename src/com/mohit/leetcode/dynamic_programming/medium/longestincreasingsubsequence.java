package com.mohit.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class longestincreasingsubsequence {

    public static void main(String[] args) {
        System.out.print("---" + new longestincreasingsubsequence().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public int lengthOfLIS_(int[] nums) {
        if (nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = new int[len];
        int maxLength = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = 1;
            int max = dp[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    max = Math.max(max, dp[i] + dp[j]);
                }
            }
            //add the current value point in the max value
            dp[i] = max;
            // Main Maximum length
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

}