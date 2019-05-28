package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class Solution {
    public int kthsmallest(TreeNode A, int B) {
        if (A == null) {
            return -1;
        }
        TreeNode node = findKMinNode(A, B);
        return node == null ? -1 : node.val;
    }

    public TreeNode findKMinNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        if (k == 1) {
            return root;
        }
        TreeNode left = findKMinNode(root.left, k);
        if (left != null) {
            return left;
        }
        k--;
        return findKMinNode(root.right, k);
    }
}