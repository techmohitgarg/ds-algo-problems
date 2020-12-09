package com.mohit;

public class Solution {


    public static void main(String[] args) {
        Solution sol = new Solution();


    }
    public int lis(int[] arr) {
        int resultMax = 0;

        int len = arr.length;
        int[] data = new int[len];

        for (int i = 0; i < len; i++) {
            data[i] = 1;
            for (int j = i; j > 0; j--) {
                if (arr[j] <= arr[j - 1]) {
                    data[i] += data[j - 1];
                }
            }
            //Checking the max total len till now
            resultMax = Math.max(resultMax, arr[i]);

        }


        return resultMax;
    }


}

