package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class SubtreeofAnotherTree {

    public static void main(String[] s) {
        SubtreeofAnotherTree anotherTree = new SubtreeofAnotherTree();
        // Add Input here;
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        if (isMatch(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    public boolean isMatch(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isMatch(s.left, t.left) && isMatch(s.right, t.right);
    }


}
