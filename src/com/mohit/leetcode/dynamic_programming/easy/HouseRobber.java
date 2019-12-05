package com.mohit.leetcode.dynamic_programming.easy;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2,1,9,15,1}));
    }


    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            int val1 = nums[i - 2];
            int val2 = ((i - 3 < 0) ? 0 : nums[i - 3]);
            nums[i] += Math.max(val1, val2);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}