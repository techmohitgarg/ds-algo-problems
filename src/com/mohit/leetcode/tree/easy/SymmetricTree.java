package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        TreeNode treeOne = new TreeNode(1);
        treeOne.left = new TreeNode(2);
        treeOne.right = new TreeNode(2);
        treeOne.left.left = new TreeNode(3);
        treeOne.left.right = new TreeNode(4);
        treeOne.right.left = new TreeNode(4);
        treeOne.right.right = new TreeNode(3);
        System.out.println(tree.isSymmetric(treeOne));
    }

    //region isSymmetric using recursion and iteration

    /**
     * @param root tree
     * @return true or false
     */

    public boolean isSymmetric(TreeNode root) {
        return isSameSymmetricForAllChild(root, root);
    }

    public boolean isSameSymmetricForAllChild(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) {
            return false;
        }
        return isSameSymmetricForAllChild(p.left, q.right) && isSameSymmetricForAllChild(p.right, q.left);
    }

    public boolean isSymmetricUsingIteration(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // Base Case's
            //Check the node whether match or not
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
    //endregion and Iteration and Iteration
}
