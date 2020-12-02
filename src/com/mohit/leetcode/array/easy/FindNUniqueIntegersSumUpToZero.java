package com.mohit.leetcode.array.easy;

public class FindNUniqueIntegersSumUpToZero {

    /**
     *
     * @param n
     * @return
     *
     * Tc : O(n)
     * SC : O(1)
     */
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n == 1) {
            return new int[]{0};
        }
        int left = 0;
        int right = n - 1;
        int num = n / 2;
        while (left < right) {
            result[left] = num;
            result[right] = num * -1;
            left++;
            right--;
            num--;
        }

        if (n % 2 != 0) {
            result[left] = 0;
        }

        return result;
    }

}
