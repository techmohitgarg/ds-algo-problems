package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class Armstrong_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            System.out.println(Abc(n));
            t--;
        }
    }

    //371
    public static String Abc(int n) {
        int tempSum = 0;
        int a = n;
        while (a > 0) {
            tempSum += (a % 10) * (a % 10) * (a % 10);
            a = a / 10;
        }
        if (tempSum == n) {
            return "Yes";
        }

        return "No";
    }
}
