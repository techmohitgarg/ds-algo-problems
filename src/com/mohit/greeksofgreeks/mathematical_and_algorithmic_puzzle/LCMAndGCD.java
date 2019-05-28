package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class LCMAndGCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(LCM(a, b) + " " + GCD(a, b));
            t--;
        }
    }

    public static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }

    public static int GCD(int a, int b) {
        if (a == 0) {
            return b;
        }
        return GCD(b % a, a);
    }
}
