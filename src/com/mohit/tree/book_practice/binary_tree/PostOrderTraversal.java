package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {
        PostOrderTraversal traversal = new PostOrderTraversal();
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        // traversal.postOrderTraversal(tree);
        System.out.println();
        traversal.postOrderTraversal1(tree);
    }

    public void postOrderTraversal(BinaryTree root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(String.valueOf(root.data) + " ");
        }
    }

    public void postOrderTraversal1(BinaryTree root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> s = new Stack<>();
        s.push(root);
        BinaryTree prev = null;
        while (!s.isEmpty()) {
            BinaryTree current = s.peek();
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    s.push(current.left);
                } else if (current.right != null) {
                    s.push(current.right);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    s.push(current.right);
                }
            } else {
                System.out.print(String.valueOf(current.data) + " ");
                s.pop();
            }
            prev = current;
        }

    }


    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> postOrderTraversal = new ArrayList<>();
        if (A == null) {
            return postOrderTraversal;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(A);
        TreeNode prev = null;
        while (!s.isEmpty()) {
            TreeNode current = s.peek();
            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null) {
                    s.push(current.left);
                } else if (current.right != null) {
                    s.push(current.right);
                }
            } else if (current.left == prev) {
                if (current.right != null) {
                    s.push(current.right);
                }
            } else {
                postOrderTraversal.add(current.val);
                s.pop();
            }
            prev = current;
        }
        return postOrderTraversal;
    }
}
