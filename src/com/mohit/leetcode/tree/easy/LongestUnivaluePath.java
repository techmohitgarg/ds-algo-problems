package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class LongestUnivaluePath {

    public static void main(String[] s) {
        LongestUnivaluePath path = new LongestUnivaluePath();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(path.longestUnivaluePath(root));
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)),
                longestUnivaluePath(root.left, root.val) + longestUnivaluePath(root.right, root.val));
    }

    public int longestUnivaluePath(TreeNode root, int val) {
        if (root == null || root.val != val) {
            return 0;
        }
        return Math.max(longestUnivaluePath(root.left, val), longestUnivaluePath(root.right, val)) + 1;
    }
}
