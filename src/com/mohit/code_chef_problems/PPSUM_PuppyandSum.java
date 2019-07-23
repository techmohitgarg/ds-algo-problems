package com.mohit.code_chef_problems;

import java.util.Scanner;

public class PPSUM_PuppyandSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int d = sc.nextInt();
            int n = sc.nextInt();
            while (d > 0) {
                n = n * (n + 1) / 2;
                d--;
            }
            System.out.println(String.format("%d", n));
            t--;
        }
    }
}
