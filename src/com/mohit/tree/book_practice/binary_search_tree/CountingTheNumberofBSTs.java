package com.mohit.tree.book_practice.binary_search_tree;

public class CountingTheNumberofBSTs {
    public static void main(String[] s) {
        CountingTheNumberofBSTs numberofBSTs = new CountingTheNumberofBSTs();
        for (int i = 0; i < 10; i++) {
            System.out.println(numberofBSTs.getCount(i));
        }

    }

    public int getCount(int n) {
        int[] count = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}
