package com.mohit.leetcode.array.easy;/*
Problem :
-----------
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

Url : https://leetcode.com/problems/maximum-subarray/description/
*/

import java.util.List;

public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray rd = new MaxSubArray();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = rd.maxSubArray(arr);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public int maxSubArray(final List<Integer> A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            sum = sum + A.get(i);
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}