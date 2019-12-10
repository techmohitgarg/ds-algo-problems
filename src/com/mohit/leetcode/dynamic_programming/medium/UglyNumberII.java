package com.mohit.leetcode.dynamic_programming.medium;

public class UglyNumberII {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new UglyNumberII().nthUglyNumber(i));
        }
    }


    public int nthUglyNumber(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_2 = 2;
        int next_multiple_3 = 3;
        int next_multiple_5 = 5;
        int next_num = 1;
        for (int i = 1; i < n; i++) {
            next_num = Math.min(next_multiple_2, Math.min(next_multiple_3, next_multiple_5));
            dp[i] = next_num;

            if (next_num == next_multiple_2) {
                i2++;
                next_multiple_2 = dp[i2] * 2;
            }
            if (next_num == next_multiple_3) {
                i3++;
                next_multiple_3 = dp[i3] * 3;
            }
            if (next_num == next_multiple_5) {
                i5++;
                next_multiple_5 = dp[i5] * 5;
            }
        }
        return next_num;
    }
    /*public int nthUglyNumber(int n) {
        if (n <= 1) {
            return n;
        }
        int num = 1;
        while (n > 1) {
            if (isUgly(++num)) {
                n--;
            }
        }
        return num;
    }

    private boolean isUgly(int num) {
        num = maxDivide(num, 2);
        num = maxDivide(num, 3);
        num = maxDivide(num, 5);
        return num == 1;
    }

    static int maxDivide(int a, int b) {
        while (a % b == 0)
            a = a / b;
        return a;
    }*/
}