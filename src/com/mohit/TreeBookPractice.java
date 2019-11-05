package com.mohit;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TreeBookPractice {


    public static void main(String[] args) {
        //[10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode t1 = MakeTree.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        TreeNode t2 = MakeTree.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        System.out.println(new TreeBookPractice().mergeTrees(t1, t2));
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode temp = null;
        if (t1 != null && t2 != null) {
            temp = new TreeNode(t1.val + t2.val);
        }
        temp.left = mergeTrees(t1.left, t2.left);
        temp.right = mergeTrees(t1.right, t2.right);
        return temp;
    }

}
