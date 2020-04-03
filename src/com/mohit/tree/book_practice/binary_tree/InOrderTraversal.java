package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;
import java.util.List;
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
        traversal.inOrder(tree);
        System.out.println();
        traversal.inorderTraversal(tree);
    }

    public void inOrder(BinaryTree root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(String.valueOf(root.data) + " ");
            inOrder(root.right);
        }
    }

    public List<Integer> inorderTraversal(BinaryTree root) {
        List<Integer> inorderTraversalList = new ArrayList<>();
        if (root == null) return inorderTraversalList;
        Stack<BinaryTree> prevNodes = new Stack<>();
        while (true) {
            if (root != null) {
                // Push the current node to stack
                prevNodes.push(root);
                // move to left
                root = root.left;
            } else {
                // Break the loop stack is empty because we don't have more nodes to traverse
                if (prevNodes.isEmpty()) break;
                //Pop the current node root and add to the output list
                root = prevNodes.pop();
                inorderTraversalList.add(root.data);
                //Move to the Right
                root = root.right;
            }
        }
        return inorderTraversalList;
    }
}
