package com.mohit.leetcode.tree.medium;

import com.mohit.TreeBookPractice;
import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] s) {
        System.out.println(new CountCompleteTreeNodes().countNodes(MakeTree.stringToTreeNode("[1]")));

    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root);
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.right != null) {
            sum += 2;
        } else if (root.left != null && root.right == null) {
            sum += 1;
        }
        return sum + count(root.left) + count(root.right);
    }
}
