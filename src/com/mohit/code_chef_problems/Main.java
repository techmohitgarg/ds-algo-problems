package com.mohit.code_chef_problems;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] values = new int[t];
        for (int i = 0; i < t; i++) {
            values[i] = sc.nextInt();
        }
        sort_(values, 0, values.length - 1);
        for (int value : values) {
            System.out.println(String.valueOf(value));
        }
    }

    public static void sort_(int[] num, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            sort_(num, left, mid);
            sort_(num, mid + 1, right);
            merge(num, left, right, mid);
        }
    }

    private static void merge(int[] num, int left, int right, int mid) {
        int l1 = mid - left + 1;
        int l2 = right - mid;

        int[] t1 = new int[l1];
        int[] t2 = new int[l2];

        for (int i = 0; i < t1.length; i++) {
            t1[i] = num[i + left];
        }
        for (int i = 0; i < t2.length; i++) {
            t2[i] = num[mid + 1 + i];
        }

        int l = left;
        int i = 0;
        int j = 0;
        while (i < t1.length && j < t2.length) {
            if (t1[i] <= t2[j]) {
                num[l++] = t1[i++];
            } else {
                num[l++] = t2[j++];
            }
        }
        while (i < t1.length) {
            num[l++] = t1[i++];
        }
        while (j < t2.length) {
            num[l++] = t2[j++];
        }
    }

}
