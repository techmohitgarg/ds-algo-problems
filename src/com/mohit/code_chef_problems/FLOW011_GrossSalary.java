package com.mohit.code_chef_problems;

import java.util.Scanner;

public class FLOW011_GrossSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            double bs = sc.nextInt();
            double gs;
            if (bs < 1500) {
                gs = bs + (bs / 10) + (bs - (bs / 10));
            } else {
                gs = bs + 500 + (bs - (bs * 2 / 100));
            }
            System.out.println(String.format("%.2f", gs));
            t--;
        }
    }
}
