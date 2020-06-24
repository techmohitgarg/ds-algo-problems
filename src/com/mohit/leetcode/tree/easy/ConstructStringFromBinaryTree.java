package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class ConstructStringFromBinaryTree {

    public static void main(String[] s) {
        ConstructStringFromBinaryTree binaryTree = new ConstructStringFromBinaryTree();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        System.out.println(binaryTree.tree2str(node));
    }

    //region Construct String from Binary Tree
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder builder = new StringBuilder();
        constructStringUsingTree(t, builder);
        return builder.toString();
    }


    private void constructStringUsingTree(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            constructStringUsingTree(root.left, sb);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            constructStringUsingTree(root.right, sb);
            sb.append(")");
        }
    }
    //endregion

}
