package com.mohit.leetcode.array.medium;

/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray productSubarray = new MaximumProductSubarray();
        System.out.println(productSubarray.maxProduct(new int[]{2, 3, -2, 4}));

    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxProduct = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            max = max * temp;
            min = min * temp;
            if (min > max) {
                int pMax = max;
                max = min;
                min = pMax;
            }
            if (temp > max) {
                max = temp;
            }
            if (min > temp) {
                min = temp;
            }
            maxProduct = Math.max(max, maxProduct);
        }
        return maxProduct;
    }
//    public int maxProduct(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int max = nums[0];
//        int currentMin = nums[0];
//        int currentMax = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            int temp = currentMax;
//            currentMax = max(nums[i], max(currentMax * nums[i], currentMin * nums[i]));
//            currentMin = min(nums[i], min(temp * nums[i], currentMin * nums[i]));
//            max = max(max, currentMax);
//        }
//        return max;
//    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }
}
