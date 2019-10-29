package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstructingbinarytreefromGivenInorderandPostOrder {

    public static void main(String[] args) {
        //[9,3,15,20,7]
        //[9,15,7,20,3]
        ConstructingbinarytreefromGivenInorderandPostOrder inorderandPreorder = new ConstructingbinarytreefromGivenInorderandPostOrder();
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        TreeNode treeNode = inorderandPreorder.buildTree(inOrder, postOrder);
        System.out.println(treeNode);
    }


    public TreeNode constructBinaryTree(int[] postOrder, int[] inOrder) {
        if (postOrder == null || inOrder == null || postOrder.length != inOrder.length) {
            return null;
        }
        return buildBinaryTree(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
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


    int postStart = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length != inorder.length) {
            return null;
        }

        postStart = postorder.length - 1;
        // Make HashMap to avoid search index in Inorder arr for preOrder value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // Return tree root here
        return buildTree(postorder, map, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> map, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        // getting preStart index value from preOrder array
        int data = postorder[postStart--];
        // Make a new node with new data
        TreeNode root = new TreeNode(data);
        // If both has same value means doesn't have child's
        if (inStart == inEnd) return root;
        // Get the iIndex value from map
        int iIndex = map.get(data);
        // call right subtree
        root.right = buildTree(postorder, map, iIndex + 1, inEnd);
        // Call left subtree
        root.left = buildTree(postorder, map, inStart, iIndex - 1);
        //return root node
        return root;
    }

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if (postorder == null || inorder == null || postorder.size() != inorder.size()) {
            return null;
        }

        postStart = postorder.size() - 1;
        // Make HashMap to avoid search index in Inorder arr for preOrder value
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }
        // Return tree root here
        return buildTree(postorder,map,0,postorder.size()-1);
    }
    private TreeNode buildTree(ArrayList<Integer> postorder, HashMap<Integer, Integer> map, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        // getting preStart index value from preOrder array
        int data = postorder.get(postStart--);
        // Make a new node with new data
        TreeNode root = new TreeNode(data);
        // If both has same value means doesn't have child's
        if (inStart == inEnd) return root;
        // Get the iIndex value from map
        int iIndex = map.get(data);
        // call right subtree
        root.right = buildTree(postorder, map, iIndex + 1, inEnd);
        // Call left subtree
        root.left = buildTree(postorder, map, inStart, iIndex - 1);
        //return root node
        return root;
    }
}
