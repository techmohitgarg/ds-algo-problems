package com.mohit.interviewbit.array;


import java.util.*;

public class NRepeatNumber {
    public static void main(String[] args) {
        NRepeatNumber continuousSubarray = new NRepeatNumber();
        int[] nums = {1, 2, 3, 1, 1};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(continuousSubarray.repeatedNumber(list));
    }

    public int repeatedNumber(final List<Integer> a) {
        if (a.size() == 0) {
            return -1;
        }
        int n = a.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            int val = a.get(i);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > n / 3) {
                return key;
            }
        }
        return -1;
    }
}
