package com.mohit.code_chef_problems;

import java.util.Scanner;

public class FLOW016_GCDandLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            // GCD (Greatest Common Divider)
            long GCD = GCD(a, b);
            // LCM (Least Common Multiple)
            long LCM = (a * b) / GCD;
            System.out.println(String.format("%d %d", GCD, LCM));
            t--;
        }

    }

    public static long GCD(long a, long b) {
        if (a == 0) return b;
        return GCD(b % a, a);
    }


}
