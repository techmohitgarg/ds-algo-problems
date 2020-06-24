package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.List;

public class ConvertSortedArrayToBinary {

    public static void main(String[] s) {
        new ConvertSortedArrayToBinary().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }

    //region sortedArrayToBST using Recursion
    /**
     * @param nums Sorted Array
     * @return return binary search tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeBinaryTree(nums, left, mid - 1);
        node.right = makeBinaryTree(nums, mid + 1, right);
        return node;
    }

    public TreeNode sortedArrayToBST(final List<Integer> A) {
        return makeBinaryTree(A, 0, A.size() - 1);
    }

    private TreeNode makeBinaryTree(List<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode l = makeBinaryTree(nums, left, mid - 1);
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = l;
        node.right = makeBinaryTree(nums, mid + 1, right);
        return node;
    }
    //endregion
}
