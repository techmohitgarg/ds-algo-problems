package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;


public class InsertElementBinarySearchTrees {

    public static void main(String[] s) {
        int[] arr = {3, 20, 48, 23, 43, 42, 12, 30};
        InsertElementBinarySearchTrees searchTrees = new InsertElementBinarySearchTrees();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = searchTrees.addItem(root, arr[i]);
        }
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

    public TreeNode addItem1(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            if (root.val > data) {
                root.left = addItem1(root.left, data);
            } else if (root.val < data) {
                root.right = addItem1(root.right, data);
            }
        }
        return root;
    }


}
