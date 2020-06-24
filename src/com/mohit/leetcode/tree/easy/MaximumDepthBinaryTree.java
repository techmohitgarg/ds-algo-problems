package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        MaximumDepthBinaryTree binaryTree = new MaximumDepthBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.right.right = new TreeNode(15);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(binaryTree.maxDepth(tree));
    }

    //region maxDepth using recursion and iteration

    /**
     * @param root tree
     * @return max Depth of the tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    public int maxDepthUsingIteration(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null);
        int max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node != null) {

                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);


            } else {
                max++;
                if (!nodes.isEmpty()) {
                    nodes.add(null);
                }
            }

        }

        return max;
    }

    //endregion


}
