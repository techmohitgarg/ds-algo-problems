package com.mohit.code_chef_problems;

import java.util.Scanner;

public class SUMAGCD_SumandGCD {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }

        }*/
        System.out.println(gcd(4, 7));
    }


    //GCD
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

}
