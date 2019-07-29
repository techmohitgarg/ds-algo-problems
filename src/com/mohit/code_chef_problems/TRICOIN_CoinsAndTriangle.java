package com.mohit.code_chef_problems;

import java.util.Scanner;

public class TRICOIN_CoinsAndTriangle {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int c = s.nextInt();
            height(c);
            t--;
        }
    }

    private static void height(int c) {
        int height = 0;
        while (c - (height + 1) >= 0) {
            c -= height + 1;
            height++;
        }
        System.out.print(String.format("%d]", height));
    }


}
