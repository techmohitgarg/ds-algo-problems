package com.mohit.leetcode.array.easy;

public class RunningSumOfArray {


    /**
     *
     * @param nums array of integer's
     * @return the running sum of given array
     * TC :O(N)
     * SC :O(1)
     */
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n) {
            nums[i] += nums[i - 1];
            i++;
        }
        return nums;
    }
}
