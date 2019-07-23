package com.mohit.code_chef_problems;

import java.util.Scanner;

public class FLOW014_GradeTheSteel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();

            int grade = 0;
            if (a > 50 && b < 0.7 && c > 5600) {
                grade = 10;
            } else if (a > 50 && b < 0.7) {
                grade = 9;
            } else if (b < 0.7 && c > 5600) {
                grade = 8;
            } else if (a > 50 && c > 5600) {
                grade = 7;
            } else if (a > 50 || b < 0.7 || c > 5600) {
                grade = 6;
            } else {
                grade = 5;
            }
            System.out.println(String.format("%d", grade));
            t--;
        }
    }
}
