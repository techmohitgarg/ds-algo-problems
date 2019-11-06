package com.mohit.leetcode.array.easy;
/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6

Example 2:
Input: [1,2,3,4]
Output: 24

Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

https://leetcode.com/problems/maximum-product-of-three-numbers/
*/

import java.util.Arrays;

class MaximumProductofThreeNumbers {
    public static void main(String[] args) {
        MaximumProductofThreeNumbers threeNumbers = new MaximumProductofThreeNumbers();
        int[] nums = {-3, -1, 2, 4};
        int result = threeNumbers.maximumProduct(nums);
        System.out.println(result);
    }

    public int maximumProduct(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    /*public int maximumProduct(int[] nums) {
        int m1 = Integer.MAX_VALUE, m2 = m1;//O(1)
        int m5 = Integer.MIN_VALUE, m4 = m5, m3 = m4;//O(1)
        // Find the first and second small numbers
        for (int val : nums) {//O(n)
            if (m1 > val) {
                m2 = m1;
                m1 = val;
            } else if (m2 > val) {
                m2 = val;
            }
            // find the last 3 large numbers
            if (m5 < val) {
                m3 = m4;
                m4 = m5;
                m5 = val;
            } else if (m4 < val) {
                m3 = m4;
                m4 = val;
            } else if (m3 < val) {
                m3 = val;
            }
        }
        return Math.max((m1 * m2 * m5), (m5 * m4 * m3));//O(1)
    }*/

}