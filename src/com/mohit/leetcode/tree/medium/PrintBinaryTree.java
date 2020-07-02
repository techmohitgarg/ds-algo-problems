package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {

    public static void main(String[] s) {
        PrintBinaryTree addOneRowtoTree = new PrintBinaryTree();
        TreeNode root1 = MakeTree.stringToTreeNode("[1,2]");
        System.out.println(addOneRowtoTree.printTree(root1));
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return new ArrayList<>();

        // Get the max Height of the tree
        int m = maxHeight(root);
        int n = (int) Math.pow(2, m) - 1;
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> strings = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                strings.add("");
            }
            lists.add(strings);
        }
        printTree(root, 0, n - 1, 0, lists, n);

        return lists;
    }

    private void printTree(TreeNode root, int left, int right, int level, List<List<String>> lists, int n) {
        if (root == null || left > right) return;

        int position = (right + left) / 2;

        lists.get(level).set(position, String.valueOf(root.val));


        printTree(root.left, left, position - 1, level + 1, lists, n);
        printTree(root.right, position + 1, right, level + 1, lists, n);

    }


    private int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
}
