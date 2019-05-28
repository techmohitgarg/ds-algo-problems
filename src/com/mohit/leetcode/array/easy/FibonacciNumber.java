package com.mohit.leetcode.array.easy;

public class FibonacciNumber {
    public static void main(String[] args) {

    }

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N - 1) + fib(N - 2);
    }

    public int fib1(int N) {
        if (N <= 1) {
            return N;
        }
        int t1 = 0;
        int t2 = 1;
        int fab = 0;
        for (int i = 2; i <= N; i++) {
            fab = t1 + t2;
            t1 = t2;
            t2 = fab;
        }
        return fab;
    }
}
