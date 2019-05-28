package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            System.out.println(Abc(a));
            t--;
        }
    }

    public static String Abc(int n) {
        boolean b = false;
        if (n == 0 || n == 1) {
            return "No";
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    b = true;
                    break;
                }
            }

        }
        if (!b) {
            return "Yes";
        }
        return "No";
    }
}
