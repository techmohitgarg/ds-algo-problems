package com.mohit.cses.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RemovingDigits {

    public static void main(String[] args) {
        RemovingDigits digits = new RemovingDigits();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(digits.removingDigits(n));
    }


    private int removingDigits(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base Case's
        for (int i = 0; i <= 9 && i <= n; i++) {
            dp[i] = 1;
        }

        for (int i = 10; i <= n; i++) {
            List<Integer> digits = getDigits(i);
            for (int j = 0; j < digits.size(); j++) {

                int sub_res = dp[i - digits.get(j)];

                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i])
                    dp[i] = sub_res + 1;
            }
        }

        return dp[n];
    }

    private List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            if (num % 10 != 0) {
                digits.add(num % 10);
            }
            num /= 10;
        }
        return digits;
    }

}
