//package com.mohit.cses.dynamic_programming;

import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        EditDistance distance = new EditDistance();
        Scanner sc = new Scanner(System.in);
        System.out.println(distance.editDistance(sc));
    }


    private int editDistance(Scanner sc) {
        String s1 = sc.next();
        String s2 = sc.next();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        //Base Case
        dp[0][0] = 0;

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
