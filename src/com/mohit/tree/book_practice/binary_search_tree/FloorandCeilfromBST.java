package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class FloorandCeilfromBST {

    public static void main(String[] args) {
        FloorandCeilfromBST ceilfromBST = new FloorandCeilfromBST();
        int[] nums = {1, 2, 8, 10, 10, 12, 19};
        TreeNode root = new BinarySearchTree(nums).getBinaryTree();
        System.out.println(ceilfromBST.getFloorofTheTree(root, 5));
    }

    public int getFloorofTheTree(TreeNode root, int value) {
        if (root == null) {
            return -1;
        }
        if (root.val == value) {
            return root.val;
        }
        if (root.val < value) {
            return getFloorofTheTree(root.right, value);
        }
        int ceil = getFloorofTheTree(root.left, value);
        return ceil >= value ? ceil : root.val;
    }
}