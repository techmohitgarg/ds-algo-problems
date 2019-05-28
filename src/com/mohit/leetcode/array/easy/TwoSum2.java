package com.mohit.leetcode.array.easy;

import java.util.HashMap;

/*
Problem:
-----------
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

Url : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
*/

public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println("Hello World");
        TwoSum2 twoSum = new TwoSum2();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum.twoSum(arr, target);
        for (int var : result) {
            System.out.print(var);
            System.err.print(" ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer val = temp.get(target - nums[i]);
            if (val == null) {
                temp.put(nums[i], i);
            } else {
                result[0] = val + 1;
                result[1] = i + 1;
                return result;
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
        }
        return result;
    }

}
