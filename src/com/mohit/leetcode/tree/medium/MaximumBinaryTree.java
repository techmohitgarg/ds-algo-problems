package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.Stack;

public class MaximumBinaryTree {


    public static void main(String[] s) {
        MaximumBinaryTree tree = new MaximumBinaryTree();
        int[] num = {3, 2, 1, 6, 0, 5};
        TreeNode node = tree.constructMaximumBinaryTree(num);
        System.out.println(node);
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stk = new Stack<>();
        for (int i = 0; i < nums.length; ++i) {
            TreeNode cur = new TreeNode(nums[i]);
            while (!stk.empty() && stk.peek().val < nums[i]) {
                cur.left = stk.peek();
                stk.pop();
            }
            if (!stk.empty())
                stk.peek().right = cur;
            stk.push(cur);
        }
        return stk.firstElement();
    }

    /*public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = constructMaximumBinaryTree(nums, 0, nums.length - 1);
        return root;
    }*/


    public TreeNode constructMaximumBinaryTree(int[] num, int left, int right) {
        if (left > right) return null;

        int mid = left; //Mid is the max value
        for (int i = left; i <= right; i++) {
            if (num[i] > num[mid]) {
                mid = i;
            }
        }
        TreeNode node = new TreeNode(num[mid]);
        node.left = constructMaximumBinaryTree(num, left, mid - 1);
        node.right = constructMaximumBinaryTree(num, mid + 1, right);
        return node;
    }
}
