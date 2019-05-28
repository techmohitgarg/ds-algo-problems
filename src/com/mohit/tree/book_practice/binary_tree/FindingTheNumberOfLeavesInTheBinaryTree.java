package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindingTheNumberOfLeavesInTheBinaryTree {

    public static void main(String[] args) {
        FindingTheNumberOfLeavesInTheBinaryTree numberOfLeavesInTheBinaryTree = new FindingTheNumberOfLeavesInTheBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.right.left = new TreeNode(6);
        tree.left.right.right = new TreeNode(7);
        System.out.println(numberOfLeavesInTheBinaryTree.findLeavesOfBinaryTree(tree));
        System.out.println(numberOfLeavesInTheBinaryTree.findLeavesOfBinaryTree1(tree));
    }


    public int findLeavesOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int count = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node.left == null && node.right == null) {
                count++;
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        return count;
    }

    public int findLeavesOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return findLeavesOfBinaryTree(root.left) + findLeavesOfBinaryTree(root.right);
    }


}
