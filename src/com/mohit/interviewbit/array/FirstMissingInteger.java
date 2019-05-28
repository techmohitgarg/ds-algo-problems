package com.mohit.interviewbit.array;

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingInteger {

    public static void main(String[] args) {
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
        int[] nums = {-8, -7, -6};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        System.out.println(firstMissingInteger.firstMissingPositive(list));

    }

    public int firstMissingPositive(ArrayList<Integer> a) {
        if (a.size() == 0) {
            return 0;
        }
        Collections.sort(a);
        int num = 0;
        int i;
        for (i = 0; i < a.size(); i++) {
            if (a.get(i).intValue() > 0) {
                if (a.get(i).intValue() == num + 1) {
                    num = a.get(i).intValue();
                } else {
                    num = num + 1;
                    break;
                }
            }

        }
        if (i == a.size()) {
            num++;
        }
        return num;
    }

}
