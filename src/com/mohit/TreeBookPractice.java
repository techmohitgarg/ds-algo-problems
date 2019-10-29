package com.mohit;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class TreeBookPractice {


    public static void main(String[] args) {
        //[1,2,3,4,null,5]
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
    }
    
}
