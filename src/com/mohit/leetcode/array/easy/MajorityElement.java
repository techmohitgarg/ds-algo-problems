package com.mohit.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times. You may assume that the
 * array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1: Input: [3,2,3] Output: 3
 * <p>
 * Example 2: Input: [2,2,1,1,1,2,2] Output: 2
 * Url : https://leetcode.com/problems/majority-element
 */
public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] values = {2, 2, 1, 1, 1, 2, 2};
        int result = me.majorityElement2(values);
        System.out.println(result);
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.get(nums[i]) == null) {
                maps.put(nums[i], 1);
            } else {
                maps.put(nums[i], maps.get(nums[i]) + 1);
            }
        }
        // check if element that appears more than ⌊ n/2 ⌋ times
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() > (nums.length / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int maj = -1;
        int index = 0;
        while (i < nums.length) {
            if (count == 0 || (nums[i] == nums[i - count])) {
                if (count == 0) {
                    index = i;
                }
                i++;
                count++;
            } else {
                if (count > (nums.length / 2)) {
                    maj = nums[index];
                }
                count = 0;
            }
        }
        if (count > (nums.length / 2)) {
            maj = nums[index];
        }
        return maj;
    }
}