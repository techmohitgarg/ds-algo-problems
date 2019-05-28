package com.mohit.leetcode.array.medium;

/*
                    r--;
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
https://leetcode.com/problems/3sum-closest/

[1,1,-1,-1,3]
-1
 */

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest sum = new ThreeSumClosest();
        System.out.println(sum.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));
        System.out.println(sum.threeSumClosest1(new int[]{1, 1, -1, -1, 3}, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum;
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        sum = nums[i] + nums[j] + nums[k];
                        int diff = Math.abs(target - sum);
                        if (min > diff) {
                            min = diff;
                            value = sum;
                        }
                    }
                }
            }
        }
        return value;
    }


    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = target - nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int tempSum = nums[lo] + nums[hi];
                if (tempSum > sum) {
                    hi--;
                } else if (tempSum < sum) {
                    lo++;
                } else {
                    return target;
                }
                if (Math.abs(min) > Math.abs(tempSum - sum))
                    min = tempSum - sum;
            }

        }
        return target + min;
    }


}
