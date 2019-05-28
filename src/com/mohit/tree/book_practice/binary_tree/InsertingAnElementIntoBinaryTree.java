package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertingAnElementIntoBinaryTree {
    public static void main(String[] args) {
        InsertingAnElementIntoBinaryTree element = new InsertingAnElementIntoBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
    }

    private TreeNode inseartInBinaryTreeLevel(TreeNode root, int data) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node != null) {
                if (node.left != null) {
                    nodes.offer(node.left);
                } else {
                    node.left = new TreeNode(data);
                    return root;
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                } else {
                    node.right = new TreeNode(data);
                    return root;
                }
            }
        }
        return root;
    }


    private TreeNode inseartInBinaryTreeLevel1(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
        }
        if (root.val < data) {
            root.left = inseartInBinaryTreeLevel1(root.left, data);
        }
        if (root.val > data) {
            root.right = inseartInBinaryTreeLevel1(root.right, data);
        }
        return root;
    }

}
