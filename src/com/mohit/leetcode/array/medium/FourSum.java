package com.mohit.leetcode.array.medium;
/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
https://leetcode.com/problems/4sum/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        FourSum sum = new FourSum();
        System.out.println(sum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> fourSum = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j + 1 > i && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    for (int k = j + 1; k < nums.length; k++) {
                        for (int l = k + 1; l < nums.length; l++) {
                            if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                                fourSum.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            }

                        }
                    }
                }
            }
        }
        return fourSum;
    }

}
