package com.mohit.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
https://leetcode.com/problems/majority-element-ii/
 */
public class MajorityElementII {

    public static void main(String[] args) {
        MajorityElementII elementII = new MajorityElementII();
        System.out.println(elementII.majorityElement(new int[]{1,1,1,3,3,2,2,2}));
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int start = -1;
        for (i = 0; i < nums.length; i++) {
            if (count == 0 || nums[start] == nums[i]) {
                if (count == 0) {
                    start = i;
                }
                count++;
            } else {
                if (count > (nums.length / 3)) {
                    list.add(nums[start]);
                }
                count = 1;
                start = i;
            }
        }
        if (count > (nums.length / 3)) {
            list.add(nums[i - 1]);
        }
        return list;
    }

}
