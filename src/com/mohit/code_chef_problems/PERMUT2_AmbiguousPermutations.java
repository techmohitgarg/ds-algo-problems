package com.mohit.code_chef_problems;

import java.util.Scanner;

public class PERMUT2_AmbiguousPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            int[] num = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                num[i] = sc.nextInt();
            }
            // Set result
            System.out.println((isAmbigouesPermutations(num)));
            n = sc.nextInt();
        }
    }

    // 1 4 3 2
    public static String isAmbigouesPermutations(int[] num) {
        for (int i = 1; i < num.length; i++) {
            if (num[num[i]] != i) {
                return "not ambiguous";
            }
        }
        return "ambiguous";
    }
}
