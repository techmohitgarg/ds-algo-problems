package com.mohit.leetcode.array.medium;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII search = new SearchInRotatedSortedArrayII();
        int[] nums = {1,1,3};
        System.out.println(search.search(nums, 3));

    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        // find the center point if the array
        int center = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                center = i;
                break;
            }
        }
        System.out.println(center);

        if (center == -1) {
            return binarySearch(nums, 0, nums.length, target);
        }
        if (nums[center] == target) {
            return center < 0 ? false : true;
        }
        if (nums[0] > target) {
            return binarySearch(nums, center + 1, nums.length, target);
        }
        return binarySearch(nums, 0, center, target);
    }

    public int getCenter(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int mid = (right + left) / 2;
        if (mid < right && nums[mid] >= nums[mid + 1]) {
            return mid;
        }
        if (mid > left && nums[mid] <= nums[mid - 1]) {
            return mid - 1;
        }
        if (nums[left] >= nums[mid]) {
            return getCenter(nums, left, mid - 1);
        }
        return getCenter(nums, mid + 1, right);
    }

    public boolean binarySearch(int[] num, int left, int right, int target) {
        if (left < right) {
            int mid = (right + left) / 2;
            if (num[mid] == target) {
                return true;
            }
            if (num[mid] > target) {
                return binarySearch(num, left, mid, target);
            }
            return binarySearch(num, mid + 1, right, target);
        }
        return false;
    }
}
