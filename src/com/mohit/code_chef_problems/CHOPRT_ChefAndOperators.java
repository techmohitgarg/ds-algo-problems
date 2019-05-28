package com.mohit.code_chef_problems;

import java.util.Scanner;

public class CHOPRT_ChefAndOperators {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a < b) {
                System.out.println("<");
            } else if (a > b) {
                System.out.println(">");
            } else {
                System.out.println("=");
            }
            t--;
        }


    }
}
