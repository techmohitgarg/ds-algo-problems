package com.mohit.cses.dynamic_programming;

import java.util.Scanner;

public class BookShop {

    public static void main(String[] args) {
        BookShop shop = new BookShop();
        Scanner sc = new Scanner(System.in);
        System.out.println(shop.maxBookPagesShop(sc));
    }


    //Submit Solution
    private int maxBookPagesShop(Scanner sc) {

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] booksPrice = new int[n + 1];
        int[] booksPages = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            booksPrice[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            booksPages[i] = sc.nextInt();
        }


        if (n == 0 || x == 0) return 0;
        int[][] dp = new int[n + 1][x + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                if (booksPrice[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - booksPrice[i]] + booksPages[i]);
                }
            }
        }
        return dp[n][x];
    }

    private int maxBookPagesShop2D(Scanner sc) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] booksPrice = new int[n];
        int[] booksPages = new int[n];
        for (int i = 0; i < n; i++) {
            booksPrice[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            booksPages[i] = sc.nextInt();
        }
        //base Case
        if (n == 0 || x == 0) return 0;
        // Initialise the Dp array
        int[][] dp = new int[n + 1][x + 1];
        // First Loop for Getting the Books Price
        for (int i = 1; i <= n; i++) {
            // Second Loop for the Getting the Budget from 1 till x for every book
            for (int j = 1; j <= x; j++) {
                // if No budget than we have the previous book pages count
                if (booksPrice[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // if have budget we will be having 2 choice
                    //1 . Don't want to buy than add the previous pages count
                    //2 . Want to buy - than add the current pages count in the remaining budget pages count (remain- at j -index (j - booksPrice[i]))
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - booksPrice[i - 1]] + booksPages[i - 1]);
                }
            }
        }
        return dp[n][x];
    }
}
