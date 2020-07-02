package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class VerifyPreorderSequenceInBinarySearchTree {

    public static void main(String[] s) {
        VerifyPreorderSequenceInBinarySearchTree addOneRowtoTree = new VerifyPreorderSequenceInBinarySearchTree();
        boolean treeNode = addOneRowtoTree.verifyPreorder(new int[]{1, 3, 2});
        System.out.println(treeNode);
    }

    //region Verify Preorder Sequence in Binary Search Tree
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length <= 1) return true;

        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            int node = preorder[i];

            if (node < min) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() < node) {
                min = stack.pop();
            }

            stack.push(node);
        }
        return true;
    }
    //endregion

}
