package com.mohit.leetcode.tree.hard;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class BinaryTreeMaximumPathSum {


    public static void main(String[] s) {
        BinaryTreeMaximumPathSum pathSum = new BinaryTreeMaximumPathSum();
        TreeNode node = new TreeNode(1);
        System.out.println(pathSum.maxPathSum(node));
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        pathSum(root);
        return max;
    }

    private int pathSum(TreeNode root) {
        if (root == null) return 0;
        int left = pathSum(root.left);
        int right = pathSum(root.right);
        int singleTop = Math.max(Math.max(left, right) + root.val, root.val);
        int maxTop = Math.max(left + right + root.val, singleTop);
        max = Math.max(max, maxTop);
        return singleTop;
    }
}
