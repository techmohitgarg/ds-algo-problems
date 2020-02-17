package com.mohit.greeksofgreeks.dynamic_programming;

public class TilingProblem {

    public static void main(String[] args) {
        TilingProblem problem = new TilingProblem();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " -- " + problem.findNumberOfWays(i));
        }

    }

    private int findNumberOfWays(int n) {
        if (n <= 2) {
            return n;
        }
        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n];
    }
}
