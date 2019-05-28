package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class Series_AP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(Abc(a, b, n));
            t--;
        }
    }

    public static int Abc(int a, int b, int n) {
        int val = a + (n - 1) * (b - a);
        return val;
    }
}
