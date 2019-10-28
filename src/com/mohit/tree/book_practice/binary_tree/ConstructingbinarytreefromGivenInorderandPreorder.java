package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;

public class ConstructingbinarytreefromGivenInorderandPreorder {

    public static void main(String[] args) {
        ConstructingbinarytreefromGivenInorderandPreorder inorderandPreorder = new ConstructingbinarytreefromGivenInorderandPreorder();
        int[] inOrder = {4, 2, 5, 1, 6, 3};
        int[] preOrder = {1, 2, 4, 5, 3, 6};

        TreeNode treeNode = inorderandPreorder.constructBinaryTree(preOrder, inOrder);
        System.out.println(treeNode);
    }


    public TreeNode constructBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length) {
            return null;
        }
        return buildBinaryTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || B == null || A.size() != B.size()) {
            return null;
        }
        return buildBinaryTree(A, 0, A.size() - 1, B, 0, B.size() - 1);
    }

    public TreeNode buildBinaryTree(ArrayList<Integer> A, int preStart, int preEnd, ArrayList<Integer> B, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int data = A.get(preStart);
        TreeNode newNode = new TreeNode(data);


        int offSet = inStart;
        for (; offSet < inEnd; offSet++) {
            if (data == B.get(offSet)) {
                break;
            }
        }
        newNode.left = buildBinaryTree(A, preStart + 1, preStart + offSet - inStart, B, inStart, offSet - 1);
        newNode.right = buildBinaryTree(A, preStart + offSet - inStart + 1, preEnd, B, offSet + 1, inEnd);
        return newNode;
    }

    public TreeNode buildBinaryTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int data = preOrder[preStart];
        TreeNode newNode = new TreeNode(data);


        int offSet = inStart;
        for (; offSet < inEnd; offSet++) {
            if (data == inOrder[offSet]) {
                break;
            }
        }
        newNode.left = buildBinaryTree(preOrder, preStart + 1, preStart + offSet - inStart, inOrder, inStart, offSet - 1);
        newNode.right = buildBinaryTree(preOrder, preStart + offSet - inStart + 1, preEnd, inOrder, offSet + 1, inEnd);
        return newNode;
    }

    int preStart = 0;

    /**
     * @param preOrder   pass the inOrder list or String
     * @param inOrder    pass the preOrder list or String
     * @param inStart    = first starting index 0;
     * @param inEnd      =last index means (inorder.length-1)
     * @param preStart=0
     * @return
     */
    private TreeNode makeTree(String preOrder, String inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        //Find the index from inorder tree
        char data = preOrder.charAt(preStart++);
        TreeNode root = new TreeNode(data - '0');
        if (inStart == inEnd) return root;
        // Search the perIndex Current index value in the InOrder String
        int iIndex = inStart;
        for (; iIndex < inEnd; iIndex++) {
            if (inOrder.charAt(iIndex) == data) {
                break;
            }
        }
        root.left = makeTree(preOrder, inOrder, inStart, iIndex - 1);
        root.right = makeTree(preOrder, inOrder, iIndex + 1, inEnd);
        return root;
    }
}
