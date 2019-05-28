package com.mohit.interviewbit.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepeatandMissingNumberArray {
    public static void main(String[] args) {
        RepeatandMissingNumberArray continuousSubarray = new RepeatandMissingNumberArray();
        int[] nums = {3, 1, 2, 5, 3};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(continuousSubarray.repeatedNumber(list));
    }

    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        ArrayList<Integer> list = new ArrayList<>();
        if (a.size() <= 1) {
            return list;
        }
        Collections.sort(a);
        int sum = 0;
        int repeat = -1;
        for (int i = 0; i < a.size(); i++) {
            if (i > 0 && a.get(i).intValue() == a.get(i - 1).intValue()) {
                repeat = a.get(i).intValue();
            }
            sum += a.get(i);

        }

        int i = 0;
        int totalSum = 0;
        while (i <= a.size()) {
            totalSum += i;
            i++;
        }
        int miss = totalSum-sum+repeat;
        list.add(repeat);
        list.add(miss);
        return list;
    }

}
