package com.mohit.greeksofgreeks.dynamic_programming;


public class UglyNumbers {

    public static void main(String[] args) {
        UglyNumbers sol = new UglyNumbers();
        int nth = 11;
        System.out.println(sol.nthUglyNumber(nth));
        System.out.println(sol.getNthUglyNo(nth));
    }

    /**
     * @param n
     * @return nth ugly number
     * @TC: O(N) with O(N) SC but its running time is fast
     */
    int getNthUglyNo(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n];

        int i2 = 0, i3 = 0, i5 = 0;

        dp[0] = 1;

        int next_ugly_no = 1;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;

        for (int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
            dp[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2) {
                i2++;
                next_multiple_of_2 = dp[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3) {
                i3++;
                next_multiple_of_3 = dp[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_5) {
                i5++;
                next_multiple_of_5 = dp[i5] * 5;
            }

        }
        return next_ugly_no;
    }

    /**
     * @param nth
     * @return nth ugly number
     * @TC: O(N)
     */
    public int nthUglyNumber(int nth) {
        int num = 0;
        int i = 0;
        while (i < nth) {
            num++;
            if (isUgly(num)) {
                i++;
            }
        }
        return num;
    }

    /**
     * @param no
     * @return funcation will return Whether number is ugly or not
     * @auther MohitGarg
     * @TC: O(N)
     */
    public boolean isUgly(int no) {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);
        return (no == 1);
    }

    /**
     * @param a
     * @param b
     * @return function will return num which is not divide by b
     * @TC: O(N) N means a because a=a/b so dividing by constant number
     */
    public int maxDivide(int a, int b) {
        while (a % b == 0) {
            a = a / b;
        }
        return a;
    }
}
