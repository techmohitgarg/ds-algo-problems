package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class SumofDigitisPallindromeornot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            System.out.println(Abc(n));
            t--;
        }
    }
    public static String Abc(int n) {
        int sum = 0;
        int a = n;
        while (a > 0) {
            sum += (a % 10);
            a = a / 10;
        }

        a = sum;
        int revers = 0;
        while (a > 0) {
            revers = 10 * revers + (a % 10);
            a = a / 10;
        }
        if (sum == revers) {
            return "YES";
        }

        return "NO";
    }
}
