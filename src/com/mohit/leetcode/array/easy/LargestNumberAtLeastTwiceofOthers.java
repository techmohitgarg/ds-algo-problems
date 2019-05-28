package com.mohit.leetcode.array.easy;

import java.util.Arrays;

/**
 *
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * Example 1:
 * 
 * Input: nums = [3, 6, 1, 0] Output: 1 Explanation: 6 is the largest integer,
 * and for every other number in the array x, 6 is more than twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1, 2, 3, 4] Output: -1 Explanation: 4 isn't at least as big as
 * twice the value of 3, so we return -1.
 * 
 * 
 * Note:
 * 
 * nums will have a length in the range [1, 50]. Every nums[i] will be an
 * integer in the range [0, 99].
 *
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
class LargestNumberAtLeastTwiceofOthers {
    public static void main(String[] args) {
        LargestNumberAtLeastTwiceofOthers leastTwiceofOthers = new LargestNumberAtLeastTwiceofOthers();
        int[] nums = { 3, 6, 1, 0 };
        int result = leastTwiceofOthers.dominantIndex(nums);
        System.out.println(result);
    }

    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return -1;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        int temp = nums[max];
        Arrays.sort(nums);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != temp && nums[i] * 2 > temp) {
                return -1;
            }
        }
        return max;
    }
}