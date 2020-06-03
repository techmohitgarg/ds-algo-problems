package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class BinaryTreeTilt {

    public static void main(String[] s) {
        BinaryTreeTilt treeTilt = new BinaryTreeTilt();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(treeTilt.findTilt(node));
    }

    int tilt = 0;
    public int findTilt(TreeNode root) {
        find(root);
        return tilt;
    }

    public int find(TreeNode root) {
        if (root == null) return 0;
        // Move to left
        int left = find(root.left);
        // Move to Right
        int right = find(root.right);

        tilt += Math.abs(left - right);

        return left + right + root.val;
    }

}
