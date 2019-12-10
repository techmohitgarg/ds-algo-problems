package com.mohit.leetcode.dynamic_programming.medium;

public class HouseRobberII {

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{2, 1, 1, 2}));
    }

    public int rob(int[] nums) {
        // Base Case
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp_from_root = new int[len];
        int[] dp_from_next_node = new int[len];

        // Add the Value when root used
        dp_from_root[0] = nums[0];
        dp_from_root[1] = Math.max(nums[0], nums[1]);

        // Add the value when root doesn't use
        dp_from_next_node[0] = 0;
        dp_from_next_node[1] = nums[1];
        for (int i = 2; i < len; i++) {
            dp_from_root[i] = Math.max(dp_from_root[i - 2] + nums[i], dp_from_root[i - 1]);
            dp_from_next_node[i] = Math.max(dp_from_next_node[i - 2] + nums[i], dp_from_next_node[i - 1]);

        }
        return Math.max(dp_from_root[len - 2], dp_from_next_node[len - 1]);
    }

}