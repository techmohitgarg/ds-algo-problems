package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.TreePracticeSolution;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreePracticeSolution sol = new TreePracticeSolution();
        TreeNode root1 = MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]");
    }

    //region Diameter of binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int len1 = maxDepth(root.left) + maxDepth(root.right);
        int len2 = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(len1, len2);
    }
    //endregion

    /**
     * @param root tree
     * @return max Depth of the tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

}
