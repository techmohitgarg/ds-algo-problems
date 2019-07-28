package com.mohit.code_chef_problems;

import java.util.Scanner;

public class MNMX_MinimumMaximum {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            long n = s.nextLong();
            System.out.println(String.format("%d", (n %4==0) ? n + 1 : n - 1));
            t--;
        }
    }
}
