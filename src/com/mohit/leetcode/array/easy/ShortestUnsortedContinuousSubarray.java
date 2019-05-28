package com.mohit.leetcode.array.easy;

import java.util.ArrayList;

/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
*/
class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray continuousSubarray = new ShortestUnsortedContinuousSubarray();
        int[] nums = {1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(continuousSubarray.subUnsort(list));

    }

    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int left = nums.length;
        int min = Integer.MAX_VALUE;
        int right = -1;
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (min < nums[i]) {
                left = i - 1;
            } else if (min > nums[i]) {
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (max > nums[i]) {
                right = i + 1;
            } else if (max < nums[i]) {
                max = nums[i];
            }
        }
        if (left + 1 > right - 1) {
            return 0;
        }

        return right - left - 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int left = -1;
        int right = nums.length;
        while (left < nums.length - 1) {
            if (left + 2 > nums.length || nums[left + 1] > nums[left + 2]) {
                break;
            } else {
                left++;
            }
        }
        while (right > 0) {
            if (nums[right - 1] < nums[right - 2]) {
                break;
            } else {
                right--;
            }
        }
        if (left + 1 > right - 1) {
            return 0;
        }
        return right - left - 1;
    }

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A.size() <= 1) {
            return new ArrayList<>();
        }
        int left = A.size();
        int min = Integer.MAX_VALUE;
        int right = -1;
        int max = Integer.MIN_VALUE;
        for (int i = A.size() - 1; i >= 0; i--) {
            if (min < A.get(i)) {
                left = i - 1;
            } else if (min > A.get(i)) {
                min = A.get(i);
            }
        }
        if (left >= A.size()) {
            list.add(-1);
            return list;
        }
        for (int i = 0; i < A.size(); i++) {
            if (max > A.get(i)) {
                right = i + 1;
            } else if (max < A.get(i)) {
                max = A.get(i);
            }
        }
        if (left + 1 > right - 1) {
            list.add(-1);
            return list;
        }

        list.add(left + 1);
        list.add(right - 1);
        return list;
    }
}