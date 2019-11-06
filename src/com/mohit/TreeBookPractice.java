package com.mohit;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class TreeBookPractice {


    public static void main(String[] args) {

        TreeNode t1 = MakeTree.stringToTreeNode("[2,2,5,null,null,5,7]");
        System.out.println(new TreeBookPractice().findSecondMinimumValue(t1));
    }

    public int findSecondMinimumValue(TreeNode root) {
        int first = Integer.MAX_VALUE, second = first;
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                int val = node.val;
                if (first > val) {
                    second = first;
                    first = val;
                } else if (second > val && val > first) {
                    second = val;
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                len--;
            }

        }
        if (first == second) return -1;
        return second == Integer.MAX_VALUE ? -1 : second;
    }
}
