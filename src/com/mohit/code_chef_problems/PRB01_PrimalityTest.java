package com.mohit.code_chef_problems;

import java.util.Scanner;

public class PRB01_PrimalityTest {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int num = sc.nextInt();
            System.out.println(isPrime(num) ? "yes" : "no");
            t--;
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
