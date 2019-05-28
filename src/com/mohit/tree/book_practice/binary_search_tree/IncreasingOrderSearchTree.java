package com.mohit.tree.book_practice.binary_search_tree;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class IncreasingOrderSearchTree {

    public static void main(String[] s) {
        IncreasingOrderSearchTree orderSearchTree = new IncreasingOrderSearchTree();
        int[] num = {5, 3, 6, 2, 3, 8, 1, 7, 9};
        TreeNode root = new BinarySearchTree(num).getBinaryTree();
        TreeNode node = orderSearchTree.increasingBST(root);
        System.out.println(node);

    }

    TreeNode head = null;
    TreeNode prev = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToDll(root.left);
        if (prev != null) {
            root.left = null;
            prev.right = root;
        }
        if (head == null) {
            head = root;
        }
        prev = root;
        bstToDll(root.right);
        return head;
    }

    public TreeNode increasingBST1(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToDll(root);
        TreeNode temp = head;
        TreeNode node = null;
        while (temp != null) {
            node = addItem(node, temp.val);
            temp = temp.right;
        }

        return node;
    }

    public TreeNode addItem(TreeNode node, int data) {
        if (node == null) {
            return new TreeNode(data);
        } else {
            node.left = null;
            node.right = addItem(node.right, data);
        }
        return node;
    }

    public void bstToDll(TreeNode node) {
        if (node == null) {
            return;
        }
        bstToDll(node.left);
        if (head == null) {
            head = node;
        } else {
            node.left = prev;
            prev.right = node;
        }
        prev = node;
        bstToDll(node.right);
    }


    public void setLeftTree(TreeNode root) {
        if (root == null) {
            return;
        }
        setLeftTree(root.left);
        root.left = prev;
        prev = root;
        setLeftTree(root.right);
    }

    public TreeNode setRightTree(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }

        if (root != null && root.left != null) {
            TreeNode temp = root.left;
            temp.right = root;
            root = root.left;
        }
        return root;
    }

}
