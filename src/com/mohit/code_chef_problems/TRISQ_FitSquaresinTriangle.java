package com.mohit.code_chef_problems;

import java.util.Scanner;

public class TRISQ_FitSquaresinTriangle {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int b = s.nextInt();
            int ans = 0;
            while (b > 2) {
                ans += (b - 2) / 2;
                b = b - 2;
            }
            System.out.println(String.format("%d", ans));
            t--;
        }
        /*Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int b = s.nextInt() - 2;
            b=b/2;
            System.out.println(String.format("%d", (b <= 0 ? 0 : (b * (b + 1) /2))));
            t--;
        }*/
    }
}
