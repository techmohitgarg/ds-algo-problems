package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(2);

        a.left.left = new TreeNode(3);
        a.left.right = new TreeNode(4);

        a.right.left = new TreeNode(4);
        a.right.right = new TreeNode(3);

        System.out.println(new Solution().isSymmetric(a));
    }

    //https://leetcode.com/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean isSameTree = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return isSameTree;
    }

    //https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetricUsingIterate(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            // Add the Child node in the Queue
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        boolean isSameTree = isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
        return isSameTree;
    }


}

