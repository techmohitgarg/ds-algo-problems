package com.mohit.code_chef_problems;

import java.util.Scanner;

public class GudduonDate_KS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long val = sc.nextLong();
            System.out.println(getValue(val));
            t--;
        }
    }

    public static long getValue(long val) {
        long n = val;
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        if (sum > 10) {
            return getValue(val + 1);
        }
        long diff = 10 - sum;
        long num = 10 * val + diff;
        return num;
    }
}
