package com.mohit;

import com.mohit.tree.book_practice.binary_tree.FindingTheDiameterOfTheBinaryTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeBookPractice {


    public static void main(String[] args) {
        //[1,2,3,4,null,5]
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.right.left = new TreeNode(5);

    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        boolean isSubTree = isSame(s, t);
        if (isSubTree) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }


}
