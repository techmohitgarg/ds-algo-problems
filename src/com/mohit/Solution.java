package com.mohit;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3, 1, 2, 4, 5}));
    }

    public int sumSubarrayMins(int[] A) {
        if (A.length == 0) return 0;
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        for (int i = 2; i <= A.length; i++) {
            int data = subArray(A, i);
            sum += data;
        }
        return sum;
    }

    public int subArray(int[] num, int window) {
        int i = 0;
        int sum = 0;
        while (i <= num.length - window) {
            int min = num[i];
            for (int k = i; k < i + window; k++) {
                min = Math.min(min, num[k]);
            }
            sum += min;
            i++;
        }
        return sum;
    }
}