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
        if (nums.length <= 0) {
            return null;
        }
        return getMaxTree(nums, 0, nums.length);
    }

    public TreeNode getMaxTree(int[] nums, int left, int right) {
        TreeNode temp = null;
        if (left < right) {
            int max = left;
            int i = 0;
            for (i = left; i < right; i++) {
                if (nums[max] < nums[i]) {
                    max = i;
                }
            }
            temp = new TreeNode(nums[max]);
            temp.left = getMaxTree(nums, left, max);
            temp.right = getMaxTree(nums, max + 1, right);
            return temp;
        }

        return null;
    }
}
