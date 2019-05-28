package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class UnivaluedBinaryTree {

    public static void main(String[] s) {
        UnivaluedBinaryTree binaryTree = new UnivaluedBinaryTree();
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode root, int data) {
        if (root == null) {
            return true;
        }
        if (root.val != data) {
            return false;
        }
        return isUnivalTree(root.left, data) && isUnivalTree(root.right, data);
    }

}
