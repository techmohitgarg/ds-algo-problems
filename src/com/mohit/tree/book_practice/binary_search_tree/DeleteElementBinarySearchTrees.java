package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;


public class DeleteElementBinarySearchTrees {

    public static void main(String[] s) {
        int[] arr = {20, 3, 48, 23, 43, 42, 12, 45};
        DeleteElementBinarySearchTrees searchTrees = new DeleteElementBinarySearchTrees();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = searchTrees.addItem(root, arr[i]);
        }
        TreeNode temp1 = searchTrees.deleteItemWithMax(root, 43);
        TreeNode temp2 = searchTrees.deleteItemWithMin(root, 48);
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

    // With Max Node
    public TreeNode deleteItemWithMax(TreeNode root, int data) {
        TreeNode temp = null;
        if (root == null) {
            return null;
        }
        if (root.val > data) {
            root.left = deleteItemWithMax(root.left, data);
        } else if (root.val < data) {
            root.right = deleteItemWithMax(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            temp = findMax(root.left);
            root.val = temp.val;
            root.left = deleteItemWithMax(root.left, root.val);
        }

        return root;
    }

    // With Min Node
    public TreeNode deleteItemWithMin(TreeNode root, int data) {
        TreeNode temp = null;
        if (root == null) {
            return null;
        }
        if (root.val > data) {
            root.left = deleteItemWithMin(root.left, data);
        } else if (root.val < data) {
            root.right = deleteItemWithMin(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            temp = findMin(root.right);
            root.val = temp.val;
            root.right = deleteItemWithMin(root.right, root.val);
        }

        return root;
    }


    public TreeNode findMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    public TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }
}
