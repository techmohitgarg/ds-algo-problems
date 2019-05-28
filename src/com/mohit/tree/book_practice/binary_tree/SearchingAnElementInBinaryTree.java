package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchingAnElementInBinaryTree {
    public static void main(String[] args) {
        SearchingAnElementInBinaryTree element = new SearchingAnElementInBinaryTree();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(12);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(100);
        tree.left.right = new TreeNode(12);
        tree.right.left = new TreeNode(-1);
        tree.right.right = new TreeNode(2);
        System.out.println(element.isDataExist(tree, 2));
        System.out.println(element.isDataExist1(tree, 2));
    }

    // Without Recursion
    // time :o(n) and space :o(n)
    private boolean isDataExist(TreeNode root, int data) {
        if (root != null) {
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                if (node.val == data) {
                    return true;
                }
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }

        }
        return false;
    }

    // With Recursion
    // time :o(n) and space :o(n)
    private boolean isDataExist1(TreeNode root, int data) {
        if (root == null) {
            return false;
        }
        if (root.val == data) {
            return true;
        }
        return isDataExist1(root.left, data) || isDataExist1(root.right, data);
    }
}
