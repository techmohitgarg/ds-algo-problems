package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class SecondMinimumNodeBinaryTree {

    public static void main(String[] s) {
        SecondMinimumNodeBinaryTree nodeBinaryTree = new SecondMinimumNodeBinaryTree();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(7);

        System.out.println(nodeBinaryTree.findSecondMinimumValue(node));
    }

    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        inOrder(root);
        return second == Integer.MAX_VALUE ? -1 : second;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (first > root.val) {
            second = first;
            first = root.val;
        } else if (root.val != first && root.val < second) {
            second = root.val;
        }
        inOrder(root.left);
        inOrder(root.right);
    }
}
