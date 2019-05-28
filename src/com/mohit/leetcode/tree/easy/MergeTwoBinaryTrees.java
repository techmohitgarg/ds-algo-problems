package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class MergeTwoBinaryTrees {

    public static void main(String[] s) {
        MergeTwoBinaryTrees binaryTrees = new MergeTwoBinaryTrees();

        TreeNode t1 = new TreeNode(2);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(3);
        t1.left.right = new TreeNode(4);
        t1.right.right = new TreeNode(7);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(2);
        t2.left.left = new TreeNode(5);

        TreeNode root = binaryTrees.mergeTrees(t1, t2);
        System.out.println(root);
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode temp = null;
        if (t1 != null && t2 != null) {
            temp = new TreeNode(t1.val + t2.val);
        }
        temp.left = mergeTrees(t1.left, t2.left);
        temp.right = mergeTrees(t1.right, t2.right);
        return temp;
    }
}
