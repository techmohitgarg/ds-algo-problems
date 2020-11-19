package com.mohit.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NumbersAreSmallerThanTheCurrentNumber {


    /**
     * Constraints:
     * <p>
     * 2 <= nums.length <= 500
     * 0 <= nums[i] <= 100
     *
     * @param nums array of integers numbers
     * @return array of count numbers are smaller than current number
     * TC : O(n^2)
     * SC : O(1)
     */
    public int[] smallerNumbersThanCurrent_(int[] nums) {
        //Base cases
        if (nums == null || nums.length == 0) return nums;

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j] && i != j) {
                    count++;
                }
            }
            result[i] = count;
        }


        return result;
    }

    /**
     * TC : O(n)
     * SC : O(M) M is the total length of count[]
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //Base cases
        if (nums == null || nums.length == 0) return nums;

        int[] result = new int[nums.length];

        int[] count = new int[101];

        int maxNumber = Integer.MIN_VALUE;
        int minNumber = Integer.MAX_VALUE;

        // Count the frequency for number's
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            maxNumber = Math.max(maxNumber, nums[i]);
            minNumber = Math.min(minNumber, nums[i]);
        }

        //Count all the samller number till the current number
        int sum = 0;
        for (int i = minNumber; i <= maxNumber; i++) {
            int temp = count[i];
            count[i] = sum;
            sum = sum + temp;
        }

        // Add the Result into the result array
        for (int i = 0; i < nums.length; i++) {
            result[i] = count[nums[i]];
        }

        return result;
    }

}
