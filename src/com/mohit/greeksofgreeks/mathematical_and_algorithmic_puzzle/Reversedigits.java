package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class Reversedigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            System.out.println(Abc(a));
            t--;
        }
    }

    public static long Abc(int a) {
        long revese = 0;
        while (a > 0) {
            revese = 10 * revese + (a % 10);
            a /= 10;
        }
        return revese;
    }
}
