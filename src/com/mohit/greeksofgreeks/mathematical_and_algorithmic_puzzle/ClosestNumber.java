package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class ClosestNumber {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(abc(n, m));
            t--;
        }*/
        // 221 ,-381
        //13 4
        System.out.println(abc(221, -381));
    }

    public static int abc(int n, int m) {
        if (m < 0) {
            m = -(m);
        }
        int p = (n / m);
        int diff1 = 0;
        int diff2 = 0;
        if (n > 0) {
            diff1 = (n - p * m);
            diff2 = ((p + 1) * m - n);
            if (diff1 < diff2) {
                return (p * m);
            } else {
                return ((p + 1) * m);
            }
        } else {
            diff1 = (n - p * m);
            diff2 = ((p - 1) * m - n);
            if (diff1 > diff2) {
                return (p * m);
            } else {
                return ((p - 1) * m);
            }
        }

    }

}
