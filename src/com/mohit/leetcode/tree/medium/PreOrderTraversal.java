package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.BinaryTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {
        PreOrderTraversal traversal = new PreOrderTraversal();
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        traversal.preOrderTraversal1(tree);
    }

    public void preOrderTraversal(BinaryTree root) {
        if (root != null) {
            System.out.print(String.valueOf(root.data) + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public void preOrderTraversal1(BinaryTree root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            BinaryTree node = s.pop();
            System.out.print(String.valueOf(node.data) + " ");
            if (node.right != null) {
                s.add(node.right);
            }
            if (node.left != null) {
                s.add(node.left);
            }
        }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> preOrderTraversal = new ArrayList<>();
        if (A == null) {
            return preOrderTraversal;
        }
        Stack<TreeNode> s = new Stack<>();
        s.add(A);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            preOrderTraversal.add(node.val);
            if (node.right != null) {
                s.add(node.right);
            }
            if (node.left != null) {
                s.add(node.left);
            }
        }
        return preOrderTraversal;
    }
}
