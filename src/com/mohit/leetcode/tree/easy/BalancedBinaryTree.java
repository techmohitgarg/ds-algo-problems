package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree binaryTree = new BalancedBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(3);
        tree.left.left.left = new TreeNode(4);
        tree.left.left.right = new TreeNode(4);
        System.out.println(binaryTree.isBalanced(tree));
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return maxDepthForBalancedTree(root) == -1 ? false : true;
    }
    public int maxDepthForBalancedTree(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepthForBalancedTree(root.left);
        int right = maxDepthForBalancedTree(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }


    /*public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }*/


    //region isBalanced using Recursion
    /*public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return maxDepthForBalancedTree(root) == -1 ? false : true;
    }

    public int maxDepthForBalancedTree(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepthForBalancedTree(root.left);
        int right = maxDepthForBalancedTree(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }*/
    //endregion

}
