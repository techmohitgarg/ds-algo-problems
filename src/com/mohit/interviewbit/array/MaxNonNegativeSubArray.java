package com.mohit.interviewbit.array;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {

        MaxNonNegativeSubArray subArray = new MaxNonNegativeSubArray();
        int[] nums = {1, 2, 5, -7, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(subArray.maxset(list));

    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        if (a.size() == 0) {
            return new ArrayList<>();
        }

        long sum = 0;
        long max = 0;
        ArrayList<Integer> maxSum = new ArrayList<>();
        ArrayList<Integer> positiveArr = new ArrayList<>();
        for (Integer val : a) {
            if (val >= 0) {
                sum += val;
                positiveArr.add(val);
            } else {
                sum = 0;
                positiveArr = new ArrayList<>();
            }

            if ((max < sum) || ((max == sum) && (maxSum.size() < positiveArr.size()))) {
                max = sum;
                maxSum = positiveArr;

            }
        }
        return maxSum;
    }
}
