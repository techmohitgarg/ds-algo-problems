package com.mohit;

public class TreeBookPractice {

    public static void main(String[] args) {
        System.out.println(new TreeBookPractice().rob(new int[]{2, 7, 9, 3, 1}));
    }

    public int rob(int[] nums) {
        // Base Case
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        if (len == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        int max = Math.max(nums[0], Math.max(nums[1], nums[2]));
        max = dp(nums, 1, len - 2);
        max = Math.max(max, dp(nums, 2, len - 1));
        return max;
    }

    public int dp(int[] val, int from, int to) {
        int[] dp = val;
        if (dp.length == 0) return 0;
        if (dp.length == 1) return dp[from];
        if (dp.length == 2) return Math.max(dp[from], dp[from + 1]);
        int max = Math.max(dp[from], dp[from + 1]);
        for (int i = from + 2; i <= to; i++) {
            int val1 = dp[i - 2];
            int val2 = ((i - 3 < 0) ? 0 : dp[i - 3]);
            dp[i] += Math.max(val1, val2);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}