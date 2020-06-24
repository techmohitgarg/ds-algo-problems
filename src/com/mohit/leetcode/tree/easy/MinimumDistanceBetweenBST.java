package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class MinimumDistanceBetweenBST {

    public static void main(String[] s) {
        MinimumDistanceBetweenBST distanceBetweenBST = new MinimumDistanceBetweenBST();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(6);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        System.out.println(distanceBetweenBST.minDiffInBST(node));
    }

    Integer min = Integer.MAX_VALUE;
    Integer prev = null;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return min;
    }
    //region Minimum Distance Between BST Nodes
    /*public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        int result = minDiffBetweenNodes(root);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minDiffBetweenNodes(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = minDiffBetweenNodes(root.left);
        int diff = Integer.MAX_VALUE;
        if (prev != null) {
            diff = root.val - prev;
        }
        //Update the Previous
        prev = root.val;

        int right = minABSDiffBetweenNodes(root.right);

        return Math.min(diff, Math.min(left, right));
    }*/

    //endregion
}
