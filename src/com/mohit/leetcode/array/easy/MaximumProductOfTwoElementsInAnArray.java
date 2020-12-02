package com.mohit.leetcode.array.easy;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInAnArray {

    /**
     * Constraints:
     * <p>
     * 2 <= nums.length <= 500
     * 1 <= nums[i] <= 10^3
     * <p>
     * TC: O(n)
     * SC :O(1)
     */
    public int maxProduct(int[] nums) {

        int num1 = 0;
        int num2 = 0;

        int i = 0;
        while (i < nums.length) {
            int val = nums[i];
            if (num1 == 0 || val > num1) {
                num2 = num1;
                num1 = val;
            } else if (num2 == 0 || val > num2) {
                num2 = val;
            }
            i++;
        }

        System.out.println("1- " + num1 + " 2 - " + num2);

        return (num1 - 1) * (num2 - 1);
    }

    /**
     * TC: O(NlogN)
     * SC :O(1)
     */
    public int maxProduct_(int[] nums) {
        int result = 0;

        int len = nums.length;
        if (len > 2) {
            Arrays.sort(nums);// NlogN
        }

        result = (nums[len - 1] - 1) * (nums[len - 2] - 1);


        return result;
    }
}
