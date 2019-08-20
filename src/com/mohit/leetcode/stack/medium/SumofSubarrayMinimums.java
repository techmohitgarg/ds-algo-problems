package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class SumofSubarrayMinimums {
    public static void main(String[] args) {
        System.out.println(new SumofSubarrayMinimums().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }


    public int sumSubarrayMins(int[] A) {
        if (A.length == 0) return 0;
        int mod = 1000000007;
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        int[] min_upto = new int[A.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!s.empty() && A[s.peek()] > A[i]) {
                min_upto[s.peek()] = i - 1;
                s.pop();
            }
            s.push(i);
        }
        while (!s.empty()) {
            min_upto[s.peek()] = A.length - 1;
            s.pop();
        }
        for (int i = 2; i <= A.length; i++) {
            int data = subArray(A, min_upto, i);
            sum = (sum + data) % mod;
        }
        return sum % mod;
    }

    public int subArray(int[] num, int[] min_upto, int window) {
        int mod = 1000000007;
        int sum = 0;
        int j = 0;
        for (int i = 0; i <= num.length - window; i++) {
            while (j < i || min_upto[j] < i + window - 1) {
                j++;
            }
            sum = (sum + num[j]) % mod;
        }


        return sum;
    }
}