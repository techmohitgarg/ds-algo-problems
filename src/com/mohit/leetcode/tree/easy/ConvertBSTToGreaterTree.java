package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.TreePracticeSolution;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class ConvertBSTToGreaterTree {

    TreeNode lastNode = null;

    public static void main(String[] args) {
        ConvertBSTToGreaterTree sol = new ConvertBSTToGreaterTree();
        TreeNode root1 = MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]");

    }

    //region Binary Search Tree to Greater Sum Tree
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBstToGst(root);
        return root;
    }

    private void convertBstToGst(TreeNode root) {
        if (root == null) return;

        convertBstToGst(root.right);

        if (lastNode != null) {
            root.val += lastNode.val;
        }
        lastNode = root;

        convertBstToGst(root.left);
    }
    //endregion
}
