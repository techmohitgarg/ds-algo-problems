package com.mohit.leetcode.array.medium;

/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        MinimumSizeSubarraySum subarraySum = new MinimumSizeSubarraySum();
        int sum = 213;
        System.out.println(subarraySum.minSubArrayLen(sum, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
        System.out.println(subarraySum.minSubArrayLen1(sum, new int[]{12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12}));
    }


    public int minSubArrayLen(int s, int[] nums) {
        int minLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if ((minLen == 0 && sum >= s) || ((j - i + 1 < minLen) && sum >= s)) {
                    minLen = (j - i + 1);
                    break;
                }
                if (minLen > 0 && (j - i + 1) > minLen) {
                    break;
                }
            }
        }
        return minLen;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length, start = 0, sum = 0, minlen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                minlen = Math.min(minlen, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}
