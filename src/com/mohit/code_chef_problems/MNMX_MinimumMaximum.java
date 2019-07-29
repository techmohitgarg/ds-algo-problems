package com.mohit.code_chef_problems;

import java.util.Scanner;

public class MNMX_MinimumMaximum {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int n = s.nextInt();
            long min = 0;
            for (int i = 0; i < n; i++) {
                long val = s.nextLong();
                if (i > 0) {
                    min = Math.min(min, val);
                } else {
                    min = val;
                }
            }
            System.out.println(String.format("%d", (n - 1) * min));
            t--;
        }
    }
}
