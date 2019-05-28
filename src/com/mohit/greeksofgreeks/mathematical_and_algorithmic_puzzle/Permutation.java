package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(Abc(a, b));
            t--;
        }
    }

    public static long Abc(int a, int b) {
        long val = 1;
        long diff = a - b;
        while (a > diff) {
            val = val * a;
            a--;
        }
        return val;
    }
}
