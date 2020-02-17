package com.mohit.greeksofgreeks.dynamic_programming;

public class GoldMineProblem {

    public static void main(String[] args) {
        GoldMineProblem sol = new GoldMineProblem();
        System.out.println(sol.getMaxGold(
                new int[][]
                        {
                                {1, 3, 1, 5},
                                {2, 2, 4, 1},
                                {5, 0, 2, 3},
                                {0, 6, 1, 2}},
                4, 4));
    }


    private int getMaxGold(int gold[][], int m, int n) {

        if (m == 0 || n == 0) return 0;

        int[][] maxGold = new int[m][n];

        int max = Integer.MIN_VALUE;
        //row
        for (int i = 0; i < m; i++) {
            // col
            for (int j = n - 1; j >= 0; j--) {
                // right
                int right = (j == n - 1) ? 0 : maxGold[i][j + 1];
                // right up
                int right_up = (i == 0 || j == n - 1) ? 0 : maxGold[i - 1][j + 1];
                // right down
                int right_down = (i == m - 1 || j == n - 1) ? 0 : maxGold[i + 1][j + 1];

                // Add the max Value in MaxGold
                maxGold[i][j] = gold[i][j] + Math.max(right, Math.max(right_down, right_up));

                max = Math.max(max, maxGold[i][j]);
            }
        }
        return max;
    }
}

