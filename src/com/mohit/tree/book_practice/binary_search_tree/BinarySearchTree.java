package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;


public class BinarySearchTree {

    int[] nums;


    public BinarySearchTree(int[] nums) {
        this.nums = nums;
    }

    public TreeNode getBinaryTree() {
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = addItem(root, nums[i]);
        }
        return root;
    }

    private TreeNode addItem(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        TreeNode temp;
        if (data <= root.val) {
            temp = addItem(root.left, data);
            root.left = temp;
        } else {
            temp = addItem(root.right, data);
            root.right = temp;
        }
        return root;
    }
}
