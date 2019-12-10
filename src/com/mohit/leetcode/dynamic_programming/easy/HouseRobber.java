package com.mohit.leetcode.dynamic_programming.easy;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2, 1, 9, 15, 1}));
    }


    // With using extra space
    public int rob_(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
    // Solution Without using extra space
    public int rob__(int[] nums) {
        if (nums.length == 0) return 0;
        // Base Case
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int max = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int val1 = nums[i - 2];
            int val2 = ((i - 3 < 0) ? 0 : nums[i - 3]);
            nums[i] += Math.max(val1, val2);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    // another solution Without using extra space
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        // Base Case
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int last = nums[0];
        int max = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = max;
            max = Math.max(max, last + nums[i]);
            last = temp;
        }
        return max;
    }

}