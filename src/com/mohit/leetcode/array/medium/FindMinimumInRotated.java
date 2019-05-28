package com.mohit.leetcode.array.medium;

/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotated {

    public static void main(String[] args) {
        FindMinimumInRotated minimum = new FindMinimumInRotated();
        System.out.println(minimum.findMin(new int[]{4, 5, 6, 7, 0, 1, 1, 2}));

    }

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int middle = getMiddle(nums, 0, nums.length - 1);
        if (middle == -1) {
            return nums[0];
        } else if (middle == nums.length - 1) {
            return nums[0];
        } else {
            return nums[middle + 1];
        }
    }

    public int getMiddle(int[] nums, int left, int right) {

        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int mid = (right + left) / 2;
        if (mid < right && nums[mid] > nums[mid + 1]) {
            return mid;
        }
        if (mid > left && nums[mid] < nums[mid - 1]) {
            return mid - 1;
        }
        if (nums[left] >= nums[mid]) {
            return getMiddle(nums, left, mid - 1);
        }
        return getMiddle(nums, mid + 1, right);
    }
}
