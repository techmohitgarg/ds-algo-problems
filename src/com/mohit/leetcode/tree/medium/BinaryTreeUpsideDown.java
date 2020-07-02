package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUpsideDown {

    public static void main(String[] s) {
        BinaryTreeUpsideDown addOneRowtoTree = new BinaryTreeUpsideDown();
        TreeNode node = MakeTree.stringToTreeNode("[4,null,2,3,1]");
        TreeNode treeNode = addOneRowtoTree.upsideDownBinaryTree(node);
        System.out.println(treeNode);
    }

    // region Binary Tree Upside Down
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;

        if (root.left == null && root.right == null)
            return root;

        TreeNode left = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return left;
    }
    //endregion
}
