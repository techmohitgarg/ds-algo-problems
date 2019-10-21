package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeBookPractice {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(0);
        tree.left.right = new TreeNode(4);
        tree.left.right.left = new TreeNode(3);
        tree.left.right.right = new TreeNode(5);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(9);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

    }





}
