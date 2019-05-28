package com.mohit.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the number of
 * unique k-diff pairs in the array. Here a k-diff pair is defined as an integer
 * pair (i, j), where i and j are both numbers in the array and their absolute
 * difference is k.
 * <p>
 * Example 1: Input: [3, 1, 4, 1, 5], k = 2 Output: 2 Explanation: There are two
 * 2-diff pairs in the array, (1, 3) and (3, 5). Although we have two 1s in the
 * input, we should only return the number of unique pairs.
 * <p>
 * Example 2: Input:[1, 2, 3, 4, 5], k = 1 Output: 4 Explanation: There are four
 * 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * <p>
 * Example 3: Input: [1, 3, 1, 5, 4], k = 0 Output: 1 Explanation: There is one
 * 0-diff pair in the array, (1, 1).
 * <p>
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */
class KdiffPairs {
    public static void main(String[] args) {
        KdiffPairs pairs = new KdiffPairs();
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        int result = pairs.findPairs1(nums, k);
        System.out.println(result);
    }

    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], i);
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(k + nums[i]) && mp.get(k + nums[i]) != i) {
                cnt++;
                mp.remove(k + nums[i]);
            }
        }
        return cnt;
    }

    public int findPairs1(int[] nums, int k) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                if (binarySearch(nums, i + 1, nums.length - 1, nums[i] + k)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }


    public boolean binarySearch(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int m = (right + left) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[m] > target) {
                return binarySearch(nums, left, m - 1, target);
            } else {
                return binarySearch(nums, m + 1, right, target);
            }
        }
        return false;
    }
}