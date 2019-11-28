package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class InsertintoBinarySearchTree {

    public static void main(String[] s) {
        InsertintoBinarySearchTree searchTree = new InsertintoBinarySearchTree();

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val >= val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
