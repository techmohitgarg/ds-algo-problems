package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeBookPractice {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);
        System.out.println(new TreeBookPractice().sumOfLeftLeaves(tree));
    }


    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeaves(root, false);
    }

    public int sumOfLeaves(TreeNode root, boolean isleft) {
        if (root == null) return 0;
        int left = sumOfLeaves(root.left, true);
        if (isleft && root.left == null && root.right == null) {
            return root.val;
        }
        int right = sumOfLeaves(root.right, false);
        return left + right;
    }
}
