package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;


public class BinarySearchTreeToDLL {


    public static void main(String[] args) {
        BinarySearchTreeToDLL treeToDLL = new BinarySearchTreeToDLL();
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(36);
        /*for (int i = 0; i < arr.length; i++) {
            root = treeToDLL.addItem(root, arr[i]);
        }*/
        treeToDLL.inorder(root);
        System.out.println();
        treeToDLL.convertBSTToDLL(root);
        System.out.println();
        treeToDLL.printlist(head);


    }

    static TreeNode head = null;
    TreeNode prev = null;
    public void convertBSTToDLL(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBSTToDLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertBSTToDLL(root.right);
    }


    public TreeNode addItem(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        TreeNode temp;
        if (data <= root.val) {
            temp = addItem(root.left, data);
            root.left = temp;
        } else {
            temp = addItem(root.right, data);
            root.right = temp;
        }
        return root;
    }

    public TreeNode BSTToDLL(TreeNode root) {
        if (root == null) {
            return null;
        }
        getBstLeft(root);

        return getBstRight(root);
    }


    public void getBstLeft(TreeNode root) {
        if (root == null) {
            return;
        }
        getBstLeft(root.left);
        root.left = prev;
        prev = root;
        getBstLeft(root.right);
    }


    public TreeNode getBstRight(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        while (root != null && root.left != null) {
            TreeNode temp = root.left;
            temp.right = root;
            root = root.left;
        }
        return root;
    }

    // Traverses the DLL from left tor right
    public void printlist(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    // Standard Inorder traversal of tree
    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
