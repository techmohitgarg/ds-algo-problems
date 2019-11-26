package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class MaximumBinaryTree {


    public static void main(String[] s) {
        MaximumBinaryTree tree = new MaximumBinaryTree();
        int[] num = {3, 2, 1, 6, 0, 5};
        TreeNode node = tree.constructMaximumBinaryTree(num);
        System.out.println(node);
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = makeBinaryTree(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode makeBinaryTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            TreeNode node = new TreeNode(num[start]);
            return node;
        } else {
            // Find the max Number
            int max = start;
            for (int i = start; i <= end; i++) {
                if (num[max] < num[i]) {
                    max = i;
                }
            }
            TreeNode node = new TreeNode(num[max]);
            node.left = makeBinaryTree(num, start, max - 1);
            node.right = makeBinaryTree(num, max + 1, end);
            return node;
        }
    }
}
