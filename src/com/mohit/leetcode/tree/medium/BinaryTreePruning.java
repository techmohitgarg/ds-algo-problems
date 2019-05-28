package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class BinaryTreePruning {

    public static void main(String[] s) {
        BinaryTreePruning searchTree = new BinaryTreePruning();
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(0);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(1);
        TreeNode treeNode = searchTree.pruneTree(node);
        System.out.println(treeNode);
    }


    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (!getOne(root)) {
            return null;
        }
        return root;
    }

    public boolean getOne(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.val == 1) {
            return true;
        }
        return getOne(node.left) || getOne(node.right);
    }
}
