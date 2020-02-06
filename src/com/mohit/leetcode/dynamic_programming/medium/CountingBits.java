package com.mohit.leetcode.dynamic_programming.medium;

public class CountingBits {

    public static void main(String[] args) {
        CountingBits sol = new CountingBits();
        //System.out.println(sol.countBits(10));
        System.out.println(Math.sqrt(17));
    }


    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0)
                result[i] = result[i / 2];
            else
                result[i] = result[i - 1] + 1;
        }
        return result;
    }

    public int[] countBits1(int num) {
        // Base Case
        if (num <= 0) return new int[]{};

        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = getCount(i);
        }
        return dp;
    }

    private int getCount(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }


}

