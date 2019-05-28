package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class ConvertSortedArraytoBinary {

    public static void main(String[] s) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = addNode(root, nums[i]);
        }
        return root;
    }


    public TreeNode addNode(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        TreeNode temp;
        if (data <= root.val) {
            temp = addNode(root.left, data);
            root.left = temp;
        } else {
            temp = addNode(root.right, data);
            root.right = temp;
        }
        return root;
    }

}
