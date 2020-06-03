package com.mohit.leetcode.tree.medium;


import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class BinarySearchTreeToGreaterSumTree {


    public static void main(String[] args) {
        BinarySearchTreeToGreaterSumTree sol = new BinarySearchTreeToGreaterSumTree();
        TreeNode root = MakeTree.stringToTreeNode("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        System.out.println(sol.bstToGst(root));
    }

    TreeNode lastNode = null;

    public TreeNode bstToGst(TreeNode root) {
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


}