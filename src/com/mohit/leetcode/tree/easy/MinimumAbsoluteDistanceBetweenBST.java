package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class MinimumAbsoluteDistanceBetweenBST {

    public static void main(String[] s) {
        MinimumAbsoluteDistanceBetweenBST distanceBetweenBST = new MinimumAbsoluteDistanceBetweenBST();
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(2);
        System.out.println(distanceBetweenBST.getMinimumDifference(node));
    }

    Integer min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }
        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev));
        }
        prev = root.val;
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return min;
    }
}
