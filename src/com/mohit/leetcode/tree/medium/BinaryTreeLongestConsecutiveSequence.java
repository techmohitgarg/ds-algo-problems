package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLongestConsecutiveSequence {

    public static void main(String[] s) {
        BinaryTreeLongestConsecutiveSequence addOneRowtoTree = new BinaryTreeLongestConsecutiveSequence();
        TreeNode node = MakeTree.stringToTreeNode("");
        int treeNode = addOneRowtoTree.longestConsecutive(node);
        System.out.println(treeNode);
    }

    //region Binary Tree Longest Consecutive Sequence
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        longestConsecutiveSequencePath(root);
        return max;
    }

    public int longestConsecutiveSequencePath(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(1, longestConsecutiveSequencePath(node.left));
        int right = Math.max(1, longestConsecutiveSequencePath(node.right));
        if (node.left != null && node.left.val == node.val + 1) {
            left += 1;
        } else {
            left = 1;
        }
        if (node.right != null && node.right.val == node.val + 1) {
            right += 1;
        } else {
            right = 1;
        }
        max = Math.max(max, Math.max(left, right));

        return Math.max(left, right);
    }
    /*public int longestConsecutiveSequencePath(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(1,longestConsecutiveSequencePath(node.left));
        int right = Math.max(1,longestConsecutiveSequencePath(node.right));
        if (node.left != null) {
            left = node.val == node.left.val - 1 ? left + 1 : 1;
        }
        if (node.right != null) {
            right = node.val == node.right.val - 1 ? right + 1 : 1;
        }
        max = Math.max(max, Math.max(left, right));

        return Math.max(left, right);
    }*/
    //endregion
}
