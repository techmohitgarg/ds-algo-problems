package com.mohit.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  ,[0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
https://leetcode.com/problems/summary-ranges/
 */
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges ranges = new SummaryRanges();
        System.out.println(ranges.summaryRanges(new int[]{-1000000000, -9999, 0, 1, 2, 10, 100, 1000, 999999999, 1000000000}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        Integer start = null;
        if (nums.length == 0) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            if (start == null) {
                start = nums[i];
            } else if (i > 0 && nums[i - 1] != nums[i] - 1) {
                list.add(start + (start == nums[i - 1] ? "" : "->" + nums[i - 1]));
                start = nums[i];
            }
        }
        if (start != null || start != nums[nums.length - 1]) {
            if (start != nums[nums.length - 1]) {
                list.add(start + "->" + nums[nums.length - 1]);
            } else {
                list.add(String.valueOf(start));
            }
        }
        return list;
    }

}
