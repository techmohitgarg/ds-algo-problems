package com.mohit.code_chef_problems;

import java.util.Scanner;

public class GDOG_Greedypuppy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int coin = 0;
            for (int i = k; i > 0; i--) {
                coin = Math.max(coin, n % i);
            }
            System.out.println(String.format("%d", coin));
            t--;
        }
    }
}
