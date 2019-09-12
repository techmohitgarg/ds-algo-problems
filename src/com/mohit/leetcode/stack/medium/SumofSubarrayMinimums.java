package com.mohit.leetcode.stack.medium;

import java.util.Stack;

public class SumofSubarrayMinimums {
    public static void main(String[] args) {
        System.out.println(new SumofSubarrayMinimums().sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }


    public int sumSubarrayMins(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];

        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] > A[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{A[i], count});
            left[i] = count;
        }
        stack.clear();
        for (int i = A.length - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= A[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{A[i], count});
            right[i] = count;
        }

        int ans = 0;
        int MOD = 1000000007;
        for (int i = 0; i < A.length; ++i) {
            ans += (left[i]) * (right[i]) % MOD * A[i] % MOD;
            ans %= MOD;
        }
        return ans;
    }
}