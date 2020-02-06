package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countBits(5));
    }


    public int[] countBits(int num) {
        // Base Case
        if (num <= 0) return new int[]{};

        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = getCount(i);
        }
        return dp;
    }

    private int getCount(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }


}

