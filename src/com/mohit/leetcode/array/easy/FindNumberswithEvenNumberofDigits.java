package com.mohit.leetcode.array.easy;

public class FindNumberswithEvenNumberofDigits {

    public static void main(String[] args) {
        FindNumberswithEvenNumberofDigits sol = new FindNumberswithEvenNumberofDigits();
        System.out.println(sol.findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) { // --> O(N+1)
            if (isEvenCount(nums[i])) { // O(len of digits) * O(N+1)
                count++;
            }
        }
        return count;

        /**
         * Time Complexity : O(N* Len of digits)
         * Space Complexity : O(1)
         */
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

