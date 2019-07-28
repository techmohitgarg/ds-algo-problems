package com.mohit.code_chef_problems;

import java.util.Scanner;

public class COPS_CopsandtheThiefDevu {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int h_no = s.nextInt();
            int house = s.nextInt();
            int mint = s.nextInt();
            int totalHouseSearch = house * mint;
            int safeHouse = 0;
            boolean[] point = new boolean[101];
            for (int i = 0; i < h_no; i++) {
                int n = s.nextInt();
                int f = n + totalHouseSearch;
                int b = n - totalHouseSearch;
                if (f > 100) {
                    f = 100;
                }
                if (b < 0) {
                    b = 1;
                }
                for (int j = b; j <= f; j++) {
                    point[j] = true;
                }
            }
            for (int i = 1; i < 101; i++) {
                if (!point[i]) safeHouse++;
            }
            System.out.println(String.format("%d", safeHouse < 0 ? 0 : safeHouse));
            t--;
        }
    }
}
