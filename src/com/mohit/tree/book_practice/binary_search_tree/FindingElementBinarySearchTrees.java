package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;


public class FindingElementBinarySearchTrees {

    public static void main(String[] s) {
        int[] arr = {20, 3, 48, 23, 43, 42, 12, 30};
        FindingElementBinarySearchTrees searchTrees = new FindingElementBinarySearchTrees();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = searchTrees.addItem(root, arr[i]);
        }

        System.out.println(searchTrees.findusingIterate(root,3).val);
        System.out.println(searchTrees.findUsingRec(root,3).val);
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

    public TreeNode findUsingRec(TreeNode root, int data) {
        if (root == null) {
            return null;
        }
        if (root.val > data) {
            return findUsingRec(root.left, data);
        } else if (root.val < data) {
            return findUsingRec(root.right, data);
        }
        return root;
    }

    public TreeNode findusingIterate(TreeNode root, int data) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val == data) {
                return root;
            } else if (root.val > data) {
                root = root.left;
            } else if (root.val < data) {
                root = root.right;
            }
        }
        return null;
    }
}
