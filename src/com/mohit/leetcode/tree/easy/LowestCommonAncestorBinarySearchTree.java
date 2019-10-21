package com.mohit.leetcode.tree.easy;

import com.mohit.TreeBookPractice;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class LowestCommonAncestorBinarySearchTree {

    public static void main(String[] s) {
        TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(0);
        tree.left.right = new TreeNode(4);
        tree.left.right.left = new TreeNode(3);
        tree.left.right.right = new TreeNode(5);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        new LowestCommonAncestorBinarySearchTree().lowestCommonAncestor(tree, p, q);

    }

    // With recursion
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    //Without recursion
    public TreeNode lowestCommonAncestorWithIterate(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
