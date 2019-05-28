package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class LCAInBST {

    public static void main(String[] s) {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        LCAInBST searchTrees = new LCAInBST();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = searchTrees.addItem(root, arr[i]);
        }
        int a = 10;
        int b = 22;
        System.out.println(searchTrees.LCA(root, a, b).val);
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

    public TreeNode LCA(TreeNode root, int a, int b) {
        if (root == null) {
            return root;
        }
        if (root.val == a || root.val == b) {
            return root;
        }
        if (root.val > a && root.val > b) {
            return LCA(root.left, a, b);
        } else if (root.val < a && root.val < b) {
            return LCA(root.right, a, b);
        } else {
            return root;
        }
    }

}
