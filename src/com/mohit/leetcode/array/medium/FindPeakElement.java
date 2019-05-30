package com.mohit.leetcode.array.medium;

/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {

    public static void main(String[] args) {
        FindPeakElement peakElement = new FindPeakElement();
        System.out.println(peakElement.findPeakElement(new int[]{3, 2, 1}));
    }

    public int findPeakElement(int[] nums) {
        int i;
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        for (i = 0; i < nums.length; i++) {
            if ((i == 0 && nums[i] >= nums[i + 1]) || (i == nums.length - 1 && nums[i - 1] <= nums[i])) {
                return i;
            } else if (i > 0 && i <= nums.length - 1 && nums[i - 1] <= nums[i] && nums[i] >= nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

//    public int findPeakElement(int[] nums) {
////        if (nums.length == 0) {
////            return -1;
////        }
////        if (nums.length == 1) {
////            return 0;
////        }
////        if (nums.length == 2) {
////            if (nums[0] < nums[1]) {
////                return 1;
////            } else {
////                return 0;
////            }
////        }
////
////        int i = 0;
////        for (i = 1; i < nums.length - 1; i++) {
////            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
////                return i;
////            }
////        }
////        if (nums[i - 1] < nums[i]) {
////            return i;
////        }
////        return 0;
////    }
}
