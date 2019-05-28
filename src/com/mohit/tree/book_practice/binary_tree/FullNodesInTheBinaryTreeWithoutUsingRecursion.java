package com.mohit.tree.book_practice.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class FullNodesInTheBinaryTreeWithoutUsingRecursion {

    public static void main(String[] args) {
        FullNodesInTheBinaryTreeWithoutUsingRecursion number = new FullNodesInTheBinaryTreeWithoutUsingRecursion();
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(11);
        tree.left.left = new TreeNode(7);
        tree.left.right = new TreeNode(12);
        tree.right = new TreeNode(9);
        tree.right.left = new TreeNode(15);
        System.out.println(number.getAllNodes(tree));
        System.out.println(number.getAllNodes1(tree));
    }


    public int getAllNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null && current.right != null) {
                count++;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }

        }
        return count;
    }

    public int getAllNodes1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && root.right != null) {
            res++;
        }
        return res + getAllNodes1(root.left) + getAllNodes1(root.right);
    }

}
