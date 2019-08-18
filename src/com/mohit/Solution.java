package com.mohit;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().sumSubarrayMins(new int[]{3, 1, 2, 4, 5}));
        //System.out.println(new Solution().subArray(new int[]{3, 1, 2, 4}, 0));
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
        Integer min = null;
        Integer temp = null;
        int index = 0;
        int sum = 0;
        while (i < num.length) {
            if (window > 0) {
                // Find min number
                if (temp == null || num[temp] < num[i]) {
                    min = temp;
                    temp = i;
                } else if (min == null || num[min] < num[i]) {
                    // Update next greater num than min
                    min = i;
                }

                window--;
            } else {
                if (temp == null || num[temp] < num[i]) {
                    min = temp;
                    temp = i;
                } else if (min == null || num[min] < num[i]) {
                    // Update next greater num than min
                    min = i;
                }
            }
            // if Window is complete
            if (window == 0) {
                // Add min num in Sum
                sum += num[min];
                // if start index is same as min index update min index with next greater index which will be min number for next window
                if (min == index) {
                    min = temp;
                }
                temp = min;
                // Increase stating index of window
                index++;
            }
            i++;
        }
        return sum;
    }
}