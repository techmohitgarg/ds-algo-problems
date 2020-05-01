package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;
import java.util.List;
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
        traversal.postOrderTraversal(tree);
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
                System.out.print(current.data + " ");
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


    //Using PreOrder Traversal
    /*public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) new ArrayList<>();

        Stack<Integer> post = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                // Add the Root Value in the List
                post.push(node.val);
                //Add the Right Node And Left Node in the Stack
                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
        }
        List<Integer> postOrder = new ArrayList<>();
        while (!post.isEmpty()) {
            postOrder.add(post.pop());
        }
        return postOrder;
    }*/

    /*private void postOrderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            // Check for empty stack
            if (stack.empty()) return;
            root = stack.pop();

            if (!stack.empty() && stack.peek() == root)
                root = root.right;
            else {
                System.out.print(root.val + " ");
                root = null;
            }
        }
    }*/
}
