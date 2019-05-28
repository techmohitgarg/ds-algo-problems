package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class Factorial {
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
        long fact = 1;
        while (a > 0) {
            fact = fact * a;
            a--;
        }
        return fact;
    }
}
