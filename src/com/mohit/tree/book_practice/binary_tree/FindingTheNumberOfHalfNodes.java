package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindingTheNumberOfHalfNodes {
    public static void main(String[] args) {
        FindingTheNumberOfHalfNodes ofHalfNodes = new FindingTheNumberOfHalfNodes();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(ofHalfNodes.findHalfNodes(tree));
        System.out.println(ofHalfNodes.findHalfNodes1(tree));
    }

    public int findHalfNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
            res++;
        }
        return res + findHalfNodes(node.left) + findHalfNodes(node.right);
    }

    public int findHalfNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
                count++;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        return count;

    }

}
