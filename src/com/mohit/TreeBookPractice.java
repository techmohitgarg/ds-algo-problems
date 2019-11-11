package com.mohit;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class TreeBookPractice {


    public static void main(String[] args) {
       //[4,1,null,2,null,3]
        System.out.println(new TreeBookPractice().rob(MakeTree.stringToTreeNode("[4,1,null,2,null,3]")));

    }


    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null);
        int sumOfParents = 0;
        int sumOfChild = 0;
        boolean isParent = true;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node != null) {
                if (isParent) {
                    sumOfParents += node.val;
                } else {
                    sumOfChild += node.val;
                }
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);

            } else {
                isParent = !isParent;
                if (!nodes.isEmpty()) {
                    nodes.add(null);
                }

            }

        }

        return Math.max(sumOfChild, sumOfParents);
    }


}