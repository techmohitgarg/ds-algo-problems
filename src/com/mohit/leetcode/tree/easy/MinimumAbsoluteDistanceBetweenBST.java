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
    //region Minimum Absolute Difference in BST

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        int result = minABSDiffBetweenNodes(root);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minABSDiffBetweenNodes(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = minABSDiffBetweenNodes(root.left);
        int diff = Integer.MAX_VALUE;
        if (prev != null) {
            diff = Math.abs(prev - root.val);
        }
        //Update the Previous
        prev = root.val;

        int right = minABSDiffBetweenNodes(root.right);

        return Math.min(diff, Math.min(left, right));
    }
    //endregion
}
