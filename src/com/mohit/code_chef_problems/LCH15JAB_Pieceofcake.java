package com.mohit.code_chef_problems;

import java.util.Scanner;

public class LCH15JAB_Pieceofcake {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            String ss = s.next();
            int c = 0;
            if (ss.length() % 2 == 0) {
                int[] num = new int[26];
                int max = 0;
                for (int i = 0; i < ss.length(); i++) {
                    int index = ss.charAt(i) - 'a';
                    num[index] += 1;
                    max = Math.max(max, num[index]);
                }
                if (max == ss.length() / 2) {
                    c = 1;
                }
            }
            if (c == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            t--;
        }

    }

}
