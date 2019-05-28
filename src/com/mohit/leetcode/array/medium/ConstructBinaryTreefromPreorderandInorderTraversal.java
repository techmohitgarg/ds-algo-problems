package com.mohit.leetcode.array.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal search = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode node = search.buildTree(preorder, inorder);
        System.out.println(node);
    }

    int preStart = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildBinaryTree(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildBinaryTree(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int data = preOrder[preStart++];
        TreeNode newNode = new TreeNode(data);
        if (inStart == inEnd) {
            return newNode;
        }

        int offSet = inStart;
        for (; offSet < inEnd; offSet++) {
            if (data == inOrder[offSet]) {
                break;
            }
        }
        newNode.left = buildBinaryTree(preOrder, inOrder, inStart, offSet - 1);
        newNode.right = buildBinaryTree(preOrder, inOrder, offSet + 1, inEnd);
        return newNode;
    }
}