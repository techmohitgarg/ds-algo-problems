package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindingTheSumOfAllElementsInBinaryTree {

    public static void main(String[] args) {
        FindingTheSumOfAllElementsInBinaryTree ofAllElementsInBinaryTree = new FindingTheSumOfAllElementsInBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(ofAllElementsInBinaryTree.findSum(tree));
        System.out.println(ofAllElementsInBinaryTree.findSum1(tree));

    }

    public int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + findSum(root.left) + findSum(root.right);
    }

    public int findSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            sum += node.val;
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }
        }
        return sum;
    }
}
