package com.mohit.code_chef_problems;

import java.util.Scanner;

public class HEADBOB_TanuandHeadbob {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            char[] g;
            g = sc.next().toCharArray();
            if (g.length != n) {
                System.out.println("NOT SURE");
                return;
            }
            int Y = 0, N = 0, I = 0;
            for (int i = 0; i < n; i++) {
                if (g[i] == 'Y') Y++;
                else if (g[i] == 'N') N++;
                else if (g[i] == 'I') I++;

                if (I > 0) {
                    break;
                }
            }
            if (I > 0) {
                System.out.println("INDIAN");
            } else if (Y > 0 && I == 0) {
                System.out.println("NOT INDIAN");
            } else {
                System.out.println("NOT SURE");
            }
            t--;
        }

    }
}
