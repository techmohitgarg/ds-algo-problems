package com.mohit.greeksofgreeks.dynamic_programming;


public class FibonacciNumbers {

    public static void main(String[] args) {
        FibonacciNumbers sol = new FibonacciNumbers();
        int num = 5;
        System.out.println(sol.fib(num));
        System.out.println(sol.fibonacciNum(num));
    }

    /**
     * @param n
     * @return nth Fibonacci number
     * 
     */
    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * @param n
     * @return nth Fibonacci number
     * TC: O(N)
     * SC: O(N)
     */
    public int fibonacciNum(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
