package com.mohit.tree.book_practice.binary_tree;

public class FindTotalNumberofBinaryTree {


    public static void main(String[] args) {

        FindTotalNumberofBinaryTree numberofBinaryTree = new FindTotalNumberofBinaryTree();
        int n = 3;
        System.out.println(numberofBinaryTree.getTotalTree(n));
    }


    public int getTotalTree(int n) {
        if (n < 0) {
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

}
