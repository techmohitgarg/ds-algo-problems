package com.mohit.code_chef_problems;

import java.util.Scanner;

public class PERMUT2_AmbiguousPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n != 0) {
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }
            // Set result
            System.out.println((isAmbigouesPermutations(num)));
            n = sc.nextInt();
        }
    }

    // 1 4 3 2
    public static String isAmbigouesPermutations(int[] num) {
        int[] temp = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            int index = num[num[i] - 1] - 1;
            temp[index] = num[i];
            if (temp[i] != num[i]) {
                return "not ambiguous";
            }
        }
        return "ambiguous";
    }
}