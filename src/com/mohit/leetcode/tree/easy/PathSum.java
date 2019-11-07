package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class PathSum {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(-2);
        a.right = new TreeNode(-3);

        System.out.println(new PathSum().hasPathSum(a, -5));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
