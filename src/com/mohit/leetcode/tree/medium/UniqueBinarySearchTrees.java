package com.mohit.leetcode.tree.medium;

public class UniqueBinarySearchTrees {
    public static void main(String[] s) {
        UniqueBinarySearchTrees searchTrees = new UniqueBinarySearchTrees();

        for (int i = 0; i < 10; i++) {
            System.out.println(searchTrees.numTrees(i));
        }
    }

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                num[i] += num[j] * num[i - j - 1];
            }
        }
        return num[n];
    }
    //region Unique Binary Search Trees or Catalan number
    /*public int numTrees(int n) {
        if (n <= 1) return 1;
        int[] num = new int[n + 1];

        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                num[i] += num[j] * num[i - j - 1];
            }
        }

        return num[n];
    }*/
    //endregion
}
