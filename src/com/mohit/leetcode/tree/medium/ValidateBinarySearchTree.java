package com.mohit.leetcode.tree.medium;

import com.mohit.TreeBookPractice;
import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class ValidateBinarySearchTree {

    public static void main(String[] s) {
        TreeNode t1 = MakeTree.stringToTreeNode("[10,5,15,null,null,6,20]");
        System.out.println(new ValidateBinarySearchTree().isValidBST(t1));
    }


    // O(n) solution using inorder traversal method
    Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }

    public boolean isValid(TreeNode node) {
        if (node == null) return true;
        boolean left = isValid(node.left);
        if (prev != null && prev >= node.val) {
            return false;
        }
        prev = node.val;
        boolean right = isValidBST(node.right);
        return left && right;
    }

    /*public boolean isBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && getMax(root.left) > root.val) {
            return false;
        }
        if (root.right != null && getMin(root.right) < root.val) {
            return false;
        }
        return isBST1(root.left) && isBST1(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public boolean isValid(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        return (min < root.val && max > root.val) &&
                isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }


    // find min
    public int getMin(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public int getMax(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }*/
    //region Validate Binary Search Tree
    /*public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (left == false) return false;

        if (lastNode != null && lastNode.val >= root.val) {
            return false;
        }
        lastNode = root;
        return isValidBST(root.right);
    }*/

    //endregion
}
