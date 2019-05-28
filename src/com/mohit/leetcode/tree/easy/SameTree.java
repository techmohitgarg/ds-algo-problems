package com.mohit.leetcode.tree.easy;
/*
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
https://leetcode.com/problems/same-tree/
 */

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

    public static void main(String[] args) {
        SameTree tree = new SameTree();
        TreeNode treeOne = new TreeNode(1);
        treeOne.left = new TreeNode(2);
        treeOne.right = new TreeNode(3);

        TreeNode treeTwo = new TreeNode(1);
        treeTwo.left = new TreeNode(2);
        treeTwo.right = new TreeNode(3);
        System.out.println(tree.isSameTree(treeOne, treeTwo));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queueOne = new LinkedList<>();
        Queue<TreeNode> queueTwo = new LinkedList<>();
        queueOne.add(p);
        queueTwo.add(q);
        while (!queueOne.isEmpty() && !queueTwo.isEmpty()) {
            TreeNode nodeOne = queueOne.poll();
            TreeNode nodeTwo = queueTwo.poll();
            if ((nodeOne.val != nodeTwo.val)) {
                return false;
            }
            // First Tree
            if (nodeOne.left != null || nodeTwo.left != null) {
                if ((nodeOne.left != null && nodeTwo.left == null) || (nodeOne.left == null && nodeTwo.left != null)) {
                    return false;
                } else {
                    queueOne.add(nodeOne.left);
                    queueTwo.add(nodeTwo.left);
                }

            }
            // Second Tree
            if (nodeOne.right != null || nodeTwo.right != null) {
                if ((nodeOne.right != null && nodeTwo.right == null) || (nodeOne.right == null && nodeTwo.right != null)) {
                    return false;
                } else {
                    queueOne.add(nodeOne.right);
                    queueTwo.add(nodeTwo.right);
                }

            }


        }
        if (queueOne.isEmpty() && queueTwo.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
