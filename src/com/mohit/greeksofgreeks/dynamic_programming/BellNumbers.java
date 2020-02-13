package com.mohit.greeksofgreeks.dynamic_programming;

public class BellNumbers {


    /*
    Bell number
    1
    1   2
    2   3   5
    5   7  10  15
    15  20  27  37  52
    */
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            BellNumbers.bellNumber(i);
        }

    }


    public static int bellNumber(int n) {
        int[][] num = new int[n + 1][n + 1];
        num[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            num[i][1] = num[i - 1][i - 1];
            for (int j = 2; j <= i; j++) {
                num[i][j] = num[i][j - 1] + num[i - 1][j - 1];
            }
        }
        return num[n][n];
    }
}
