package com.mohit.code_chef_problems;

import java.util.Scanner;

public class FLOW009_TotalExpenses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            double quantity = sc.nextDouble();
            double price = sc.nextDouble();
            double total;

            total = quantity * price;
            if (quantity > 1000) {
                total -= (total / 10);
            }
            System.out.println(String.format("%.6f", total));
            t--;
        }

    }


}
