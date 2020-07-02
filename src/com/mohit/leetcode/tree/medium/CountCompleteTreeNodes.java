package com.mohit.leetcode.tree.medium;

import com.mohit.TreeBookPractice;
import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] s) {
        System.out.println(new CountCompleteTreeNodes().countNodes(MakeTree.stringToTreeNode("[1]")));

    }

    //region Count Complete Tree Nodes
    /* public int countNodes(TreeNode root) {
     *//*if (root == null) return 0;
        return 1 + count(root);*//*
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }*/

    /*public int count(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        if (root.left != null && root.right != null) {
            count += 2;
        } else if (root.left != null && root.right == null) {
            count += 1;
        }
        return count + count(root.left) + count(root.right);
    }*/
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftH = 0;
        int rightH = 0;
        TreeNode pLeft = root;
        TreeNode pRight = root;

        while (pLeft != null) {
            pLeft = pLeft.left;
            leftH++;
        }
        while (pLeft != null) {
            pLeft = pLeft.right;
            rightH++;
        }

        if (leftH == rightH) return (int)Math.pow(2, leftH) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //endregion
}
