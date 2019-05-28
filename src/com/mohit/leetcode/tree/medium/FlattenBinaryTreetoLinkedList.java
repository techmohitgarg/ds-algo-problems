package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreetoLinkedList {

    public static void main(String[] s) {
        FlattenBinaryTreetoLinkedList linkedList = new FlattenBinaryTreetoLinkedList();
        int[] num = {1, 2, 3, 4, 5, 6};
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);
        linkedList.flatten1(node);
        System.out.println(node);
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode head = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (head == null) {
                head = temp;
            } else {
                head.left = null;
                head.right = temp;
                head = head.right;
            }

            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
        }
    }

    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        flatten1(left);
        flatten1(right);
        root.right = left;
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
    }


}
