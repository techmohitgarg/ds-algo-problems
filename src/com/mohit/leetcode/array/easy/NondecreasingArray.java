package com.mohit.leetcode.array.easy;

/*

Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].

https://leetcode.com/problems/non-decreasing-array/
 */
class NondecreasingArray {
    public static void main(String[] args) {
        NondecreasingArray nondecreasingArray = new NondecreasingArray();
        int[] nums = {-1, 4, 2, 3};
        boolean result = nondecreasingArray.checkPossibility(nums);
        System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int count = 0;
        int lastMax = nums[0];
        int lastMin = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < lastMax) {
                if (++count >= 2) {
                    return false;
                }
                if (nums[i] > lastMin) {
                    lastMax = nums[i];
                }

            } else {
                lastMin = lastMax;
                lastMax = nums[i];
            }


        }
        if (count > 1) {
            return false;
        }
        return true;
    }
}