package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumElementInBinaryTree {

    public static void main(String[] args) {
        MaximumElementInBinaryTree element = new MaximumElementInBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(100);
        tree.left.right = new TreeNode(12);
        tree.right.left = new TreeNode(-1);
        tree.right.right = new TreeNode(2);
        System.out.println(element.getElements(tree));
        System.out.println(element.getElementsMax(tree));
    }

    // Without Recursion
    // time :o(n) and space :o(n)
    // We will traverse the whole tree top to bottom to find the max value.
    private int getElements(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root == null) {
            return max;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            max = Math.max(max, node.val);
            if (node.left != null) {
                nodes.offer(node.left);
            }
            if (node.right != null) {
                nodes.offer(node.right);
            }
        }
        return max;
    }

    // With Recursion
    // time :o(n) and space :o(n)
    private int getElementsMax(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = getElementsMax(root.left);
            int rightMax = getElementsMax(root.right);
            if (leftMax > rightMax) {
                max = leftMax;
            } else if (rightMax > leftMax) {
                max = rightMax;
            }
            if (root.val > max) {
                max = root.val;
            }
        }
        return max;
    }
}
