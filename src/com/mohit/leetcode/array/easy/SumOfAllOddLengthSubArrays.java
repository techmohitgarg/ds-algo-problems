package com.mohit.leetcode.array.easy;

public class SumOfAllOddLengthSubArrays {


    /**
     * Constraints:
     * <p>
     * 1 <= arr.length <= 100
     * 1 <= arr[i] <= 1000
     *
     * @param arr array of integers
     * @return total sum of all Odd length Sub arrays
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        if (arr.length == 0) return result;

        int[] sum = new int[arr.length + 1];
        // Calculate the sum of all the element
        calculateSum(arr, sum);

        for (int i = 2; i < arr.length; i += 2) {
            for (int j = 0; j < arr.length - i; j++) {
                int subArraySum = getSubArraySum(sum, j, j + i);
                result += subArraySum;
            }
        }
        // Add the total sum for i==0
        result+=sum[sum.length-1];

        return result;
    }


    private void calculateSum(int[] arr, int[] sum) {
        for (int i = 0; i < arr.length; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }
    }

    private int getSubArraySum(int[] sum, int i, int j) {
        int result = 0;
        int end = sum[j + 1];
        int start = sum[i];
        result = end - start;

        return result;
    }

}
