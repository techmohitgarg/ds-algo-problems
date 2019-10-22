package com.mohit;

import com.mohit.tree.book_practice.binary_tree.FindingTheDiameterOfTheBinaryTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeBookPractice {



    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);

    }



}
