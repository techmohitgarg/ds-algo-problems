package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class GCDoftwonumbers {
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

    public static int Abc(int a, int b) {
        if (a == 0) {
            return b;
        }
        return Abc(b % a, a);
    }
}
