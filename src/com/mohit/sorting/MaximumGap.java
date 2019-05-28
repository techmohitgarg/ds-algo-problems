package com.mohit.sorting;

import java.util.Arrays;

public class MaximumGap {
    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        System.out.println(maximumGap.maximumGap(new int[] { 3, 6, 9, 1 }));
    }

    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        Arrays.sort(nums);

        int maxGap = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }

        return maxGap;
    }
}