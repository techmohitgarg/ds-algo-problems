package com.mohit.tree.book_practice.generic_trees;

public class FIndMaxDepth {

    public static void main(String[] s) {

        FIndMaxDepth maxDepth = new FIndMaxDepth();
        int[] num = {-1, 0, 1, 6, 6, 0, 0, 2, 7};
        System.out.println(maxDepth.getDepth(num));

    }


    public int getDepth(int[] num) {
        int currentDepth = -1;
        int mazDepth = -1;
        for (int i = 0; i < num.length; i++) {
            currentDepth = 0;
            int j = i;
            while (num[j] != -1) {
                currentDepth++;
                j = num[j];
            }
            mazDepth = Math.max(mazDepth, currentDepth);
        }
        return mazDepth;
    }
}
