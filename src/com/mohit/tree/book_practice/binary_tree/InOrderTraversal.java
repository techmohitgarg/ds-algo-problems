package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        InOrderTraversal traversal = new InOrderTraversal();
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        traversal.inOrderTraversal(tree);
        System.out.println();
        traversal.inOrderTraversal1(tree);
    }

    public void inOrderTraversal(BinaryTree root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(String.valueOf(root.data) + " ");
            inOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal1(BinaryTree root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> s = new Stack<>();
        BinaryTree node = root;
        boolean isDone = false;
        while (!isDone) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                if (s.empty()) {
                    isDone = true;
                } else {
                    node = s.pop();
                    System.out.print(String.valueOf(node.data) + " ");
                    node = node.right;
                }

            }
        }

    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> inOrderTraversal = new ArrayList<>();
        if (A == null) {
            return inOrderTraversal;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = A;
        boolean isDone = false;
        while (!isDone) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                if (s.empty()) {
                    isDone = true;
                } else {
                    node = s.pop();
                    inOrderTraversal.add(node.val);
                    node = node.right;
                }

            }
        }
        return inOrderTraversal;
    }
}
