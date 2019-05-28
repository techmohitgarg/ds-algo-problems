package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;


public class FindingMInElementBinarySearchTrees {

    public static void main(String[] s) {
        int[] arr = {3, 20, 48, 23, 43, 42, 1, 30};
        FindingMInElementBinarySearchTrees searchTrees = new FindingMInElementBinarySearchTrees();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = searchTrees.addItem(root, arr[i]);
        }

        System.out.println(searchTrees.findMinUsingRec(root).val);
        System.out.println(searchTrees.findMinUsingIterate(root).val);
        System.out.println(searchTrees.findMaxUsingRec(root).val);
        System.out.println(searchTrees.findMaxUsingIterate(root).val);
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

    public TreeNode findMinUsingRec(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMinUsingRec(root.left);
    }

    public TreeNode findMinUsingIterate(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.left == null) {
                return root;
            } else {
                root = root.left;
            }
        }
        return null;
    }

    public TreeNode findMaxUsingRec(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        }
        return findMaxUsingRec(root.right);
    }

    public TreeNode findMaxUsingIterate(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.right == null) {
                return root;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
