package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeBookPractice {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        a.left = new TreeNode(2);
        a.right = new TreeNode(7);

        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(3);

        a.right.left = new TreeNode(6);
        a.right.right = new TreeNode(9);
        new TreeBookPractice().invertTree(a);

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }


}
