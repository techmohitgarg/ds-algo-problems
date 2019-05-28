package com.mohit.interviewbit.array;


import java.util.ArrayList;

public class MaximumUnsortedSubarray {
    public static void main(String[] args) {
        MaximumUnsortedSubarray continuousSubarray = new MaximumUnsortedSubarray();
        int[] nums = {1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(continuousSubarray.subUnsort(list));
    }

    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A.size() <= 1) {
            return new ArrayList<>();
        }
        int left = A.size();
        int min = Integer.MAX_VALUE;
        int right = -1;
        int max = Integer.MIN_VALUE;
        for (int i = A.size() - 1; i >= 0; i--) {
            if (min < A.get(i)) {
                left = i - 1;
            } else if (min > A.get(i)) {
                min = A.get(i);
            }
        }
        if (left >= A.size()) {
            list.add(-1);
            return list;
        }
        for (int i = 0; i < A.size(); i++) {
            if (max > A.get(i)) {
                right = i + 1;
            } else if (max < A.get(i)) {
                max = A.get(i);
            }
        }
        if (left + 1 > right - 1) {
            list.add(-1);
            return list;
        }

        list.add(left + 1);
        list.add(right - 1);
        return list;
    }
}
