package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorBinaryTree {

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
        new LowestCommonAncestorBinaryTree().lca(tree, 2, 8);

    }

    //region Lowest Common Ancestor in a Binary Tree

    /**
     * @param A tree
     * @param B node value
     * @param C node value
     * @return Ancestor of the tree
     */

    public int lca(TreeNode A, int B, int C) {
        TreeNode result = lcaNode(A, B, C);
        return result == null ? -1 : result.val;
    }

    public TreeNode lcaNode(TreeNode A, int B, int C) {
        if (A == null) return null;


        if (A.val == B || A.val == C) {
            return A;
        }

        TreeNode left = lcaNode(A.left, B, C);
        TreeNode right = lcaNode(A.right, B, C);

        if (left != null && right != null) {
            return A;
        }

        return left != null ? left : right;
    }

    public int lcaUsingList(TreeNode A, int B, int C) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        if (!findPath(one, A, B) || !findPath(two, A, C)) {
            return -1;
        }
        int i;
        for (i = 0; i < one.size() && i < two.size(); i++) {


            if (!one.get(i).equals(two.get(i)))
                break;
        }

        return one.get(i - 1);
    }

    public boolean findPath(List<Integer> list, TreeNode A, int val) {
        if (A == null) return false;

        list.add(A.val);

        if (A.val == val) return true;

        if (A.left != null && findPath(list, A.left, val)) {
            return true;
        }
        if (A.right != null && findPath(list, A.right, val)) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;
    }
    //endregion
}
