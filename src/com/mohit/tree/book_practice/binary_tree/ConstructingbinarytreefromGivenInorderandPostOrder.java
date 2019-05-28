package com.mohit.tree.book_practice.binary_tree;

public class ConstructingbinarytreefromGivenInorderandPostOrder {

    public static void main(String[] args) {
        ConstructingbinarytreefromGivenInorderandPostOrder inorderandPreorder = new ConstructingbinarytreefromGivenInorderandPostOrder();
        int[] inOrder = {4, 2, 5, 1, 6, 3};
        int[] preOrder = {4, 5, 2, 6, 3, 1};
        TreeNode treeNode = inorderandPreorder.constructBinaryTree(preOrder, inOrder);
        System.out.println(treeNode);
    }


    public TreeNode constructBinaryTree(int[] postorder, int[] inOrder) {
        if (postorder == null || inOrder == null || postorder.length != inOrder.length) {
            return null;
        }
        return buildBinaryTree(postorder, 0, postorder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode buildBinaryTree(int[] postorder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int data = postorder[preEnd];
        TreeNode newNode = new TreeNode(data);
        int offSet = inStart;
        for (; offSet < inEnd; offSet++) {
            if (data == inOrder[offSet]) {
                break;
            }
        }
        newNode.left = buildBinaryTree(postorder, preStart, preStart + offSet - inStart - 1, inOrder, inStart, offSet - 1);
        newNode.right = buildBinaryTree(postorder, preStart + offSet - inStart, preEnd - 1, inOrder, offSet + 1, inEnd);
        return newNode;
    }
}
