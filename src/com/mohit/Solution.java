package com.mohit;

import java.util.Arrays;

public class Solution {


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(singleton(new int[]{1, 1, 2, 2, 4, 5, 5}));
        System.out.println(singleton(new int[]{10, 10, 12, 12, 15, 15, 16, 18, 18}));
        System.out.println(singleton(new int[]{1, 2, 2, 5, 5, 6, 6, 7, 7}));
        System.out.println(singleton(new int[]{1, 1, 2, 5, 5, 6, 6, 7, 7}));
        System.out.println(singleton(new int[]{10, 10, 12, 12, 15, 15, 16, 16, 18}));
    }

    public static int singleton(int[] arr) {
        int m = arr.length / 2;
        if (m == 0) return arr[0];
        if (m % 2 == 1) {
            if (arr[m] == arr[m - 1]) return singleton(Arrays.copyOfRange(arr, m + 1, arr.length));
            if (arr[m] != arr[m + 1]) return arr[m];
            return singleton(Arrays.copyOfRange(arr, 0, m));
        } else {
            if (arr[m] == arr[m + 1]) return singleton(Arrays.copyOfRange(arr, m + 2, arr.length));
            if (arr[m] != arr[m - 1]) return arr[m];
            return singleton(Arrays.copyOfRange(arr, 0, m + 1));
        }
    }


}

