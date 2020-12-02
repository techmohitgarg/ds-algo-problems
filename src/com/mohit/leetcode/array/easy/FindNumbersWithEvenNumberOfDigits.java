package com.mohit.leetcode.array.easy;

public class FindNumbersWithEvenNumberOfDigits {


    /**
     * Constraints:
     * <p>
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 10^5
     *
     * @param nums array of integers
     * @return count of even numbers
     *
     * TC : O(N*M)
     * SC : O(1)
     */

    public int findNumbers_(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) { // O(N)
            String value = String.valueOf(nums[i]); //O(M) M means length of num[i]
            if (value.length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }


    /**
     *
     * @param nums array of integers
     * @return count of even numbers
     *
     * TC : O(N*M)
     * SC : O(1)
     */
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) { // --> O(N+1)
            if (isEvenCount(nums[i])) { // O(len of digits) * O(N+1)
                count++;
            }
        }
        return count;
    }

    private boolean isEvenCount(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count % 2 == 0;
    }
}

