package com.mohit.cses.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class IncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        IncreasingSubsequence subsequence = new IncreasingSubsequence();
        //subsequence.LIS(sc);
        subsequence.lengthOfLISUsingBinarySearch(sc);
    }


    //TC : O(n^2)
    // SC : O(N)
    private void LIS(Scanner sc) {

        // Input Values
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];

        int maxLIS = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            int currentMaxLength = dp[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i])
                    currentMaxLength = Math.max(currentMaxLength, dp[j] + dp[i]);
            }
            dp[i] = currentMaxLength;

            maxLIS = Math.max(maxLIS, dp[i]);
        }


        // Print the Max Length here
        System.out.println(maxLIS);

    }

    // LIS using the LCS method
    //TC : O(n^2)
    // SC : O(N*N)
    private void LIS_Using_LCS(Scanner sc) {

        // Input Values
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sortedArray = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArray);

        int[][] dp = new int[n + 1][n + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > 1 && sortedArray[j - 1] == sortedArray[j - 2]) {
                    dp[i][j] = dp[i][j - 1];
                } else if (arr[i - 1] == sortedArray[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
        System.out.println(dp[n][n]);
    }


    // using binary Search
    public void lengthOfLIS(Scanner sc) {
        // Input Values
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[arr.length];
        int len = 0;
        for (int num : arr) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        System.out.println(len);
    }

    //TC : O(NlogN)
    //SC : O(N)
    public void lengthOfLISUsingBinarySearch(Scanner sc) {
        // Input Values
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int len = 0;
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (dp[0] > num) {
                dp[0] = num;
            } else if (dp[len] < num) {
                len++;
                dp[len] = num;
            } else {
                // Num would be set some where middle in the Array
                // will find using Binary search
                int low = 0;
                int high = len - 1;
                while (low <= high) {
                    int middle = (low + high) / 2;
                    if (dp[middle] == num) {
                        break;
                    }
                    if (dp[middle] < num) {
                        low = middle + 1;
                    } else if (dp[middle] > num) {
                        high = middle - 1;
                    }
                }
                dp[low] = num;

            }
        }
        System.out.println(len + 1);
    }

}
