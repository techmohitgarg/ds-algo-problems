package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.TreePracticeSolution;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class InorderSuccessorInBST {
    public static void main(String[] args) {
        InorderSuccessorInBST sol = new InorderSuccessorInBST();
        TreeNode root1 = MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]");

    }


    //region Inorder Successor in BST
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // if node P right side is not null
        if (root == null || p == null)
            return null;

        if (p.right != null)
            return minNodeOfTheTree(p.right);


        TreeNode current = root;
        TreeNode succ = null;
        while (current != null) {
            if (current.val < p.val) {
                current = current.right;
            } else if (current.val > p.val) {
                succ = current;
                current = current.left;
            } else {
                break;
            }
        }
        return succ;
    }

    public TreeNode minNodeOfTheTree(TreeNode root) {
        if (root == null) return root;

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    //endregion
}
