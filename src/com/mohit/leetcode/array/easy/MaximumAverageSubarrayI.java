package com.mohit.leetcode.array.easy;

/*
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
Note:
1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].

https://leetcode.com/problems/maximum-average-subarray-i/
*/
class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        MaximumAverageSubarrayI subarrayI = new MaximumAverageSubarrayI();
        int[] nums = {-1};
        int k = 1;
        double result = subarrayI.findMaxAverage(nums, k);
        System.out.println(result);
    }

    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return 0;
        }
        double sum = 0;
        double maxSum = Integer.MIN_VALUE;
        int index = 0;
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            sum += nums[i];
            count++;
            if (count == k) {
                maxSum = Math.max(sum / k, maxSum);
                sum -= nums[index++];
                count--;
            }
            i++;
        }
        if (nums.length < k) {
            return sum / k;
        }
        return maxSum;
    }
}