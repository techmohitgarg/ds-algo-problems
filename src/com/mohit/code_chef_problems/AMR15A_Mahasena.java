package com.mohit.code_chef_problems;

import java.util.Scanner;

public class AMR15A_Mahasena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int even = 0;
        int odd = 0;
        while (t > 0) {
            if (sc.nextInt() % 2 == 0) {
                even++;
            } else {
                odd++;
            }
            t--;
        }
        if (even > odd) {
            System.out.println("READY FOR BATTLE");
        } else {
            System.out.println("NOT READY");
        }

    }
}
