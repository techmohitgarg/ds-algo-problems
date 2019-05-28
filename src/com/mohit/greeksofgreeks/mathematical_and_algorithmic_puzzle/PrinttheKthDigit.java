package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class PrinttheKthDigit {
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

    public static int Abc(int a, int b, int k) {
        long val = (long) Math.pow(a, b);
        long digit = -1;
        System.out.println(val);
        while (k > 0 && val > 0) {
            digit = val % 10;
            val /= 10;
            k--;
        }
        if (k > 0) {
            return 0;
        }
        return (int)digit;
    }
}
