package com.mohit.greeksofgreeks.mathematical_and_algorithmic_puzzle;

import java.util.Scanner;

public class Binarynumbertodecimalnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String n = sc.next();
            System.out.println(Abc(n));
            t--;
        }
    }

    public static int Abc(String n) {
        int decimal = 0;
        int i = 0;
        int len = n.length();
        while (len > 0) {
            int num = (n.charAt(len - 1) - '0') % 10;
            decimal += (int) Math.pow(2, i) * num;
            i++;
            len--;
        }
        return decimal;
    }
}
