package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class SearchInBinarySearchTree {


    public static void main(String[] args) {
        TreeNode t1 = MakeTree.stringToTreeNode("[2,2,2147483647]");
        System.out.println(new SearchInBinarySearchTree().searchBST(t1, 2));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) {
            return root;
        }
        return root.val > val?searchBST(root.left, val):searchBST(root.right, val);
    }


}
