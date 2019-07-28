package com.mohit.code_chef_problems;

import java.util.Scanner;

public class FRUITS_ChefandFruits {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            Integer N = s.nextInt();
            Integer M = s.nextInt();
            Integer K = s.nextInt();
            int diff = Math.abs(N - M);
            int min = 0;
            if (diff > K) {
                min = diff - K;
            }
            System.out.println(String.format("%d", min));
            t--;
        }
    }
}
