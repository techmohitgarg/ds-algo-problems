package com.mohit.cses.dynamic_programming;

import java.util.Scanner;

public class RectangleCutting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RectangleCutting cutting = new RectangleCutting();

        cutting.getMinCutCount(sc);
    }

    private void getMinCutCount(Scanner sc) {

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] dp = new int[a + 1][b + 1];

        // Height
        for (int height = 1; height <= a; height++) {

            // Breath
            for (int width = 1; width <= b; width++) {
                // Check if there are same L*B Like 1*1,2*2,3*3
                if (height == width)
                    dp[height][width] = 0;
                else {
                    // try to make all possible vertical cut
                    int ans = Integer.MAX_VALUE;

                    for (int k = 1; k < width; k++) {
                        ans = Math.min(ans, 1 + dp[height][width - k] + dp[height][k]);
                    }

                    // try to make all possible horizontal cut
                    for (int k = 1; k < height; k++) {
                        ans = Math.min(ans, 1 + dp[height - k][width] + dp[k][width]);
                    }

                    dp[height][width] = ans;
                }
            }

        }

        // Print the Final Ans here
        System.out.println(dp[a][b]);
    }
}
