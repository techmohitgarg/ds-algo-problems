package com.mohit;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.Node;
import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.*;

public class TreeBookPractice {

    public static void main(String[] args) {
        //TreeNode node = MakeTree.stringToTreeNode("[1,1,1,1,1,1,1,null,null,null,1,null,null,null,null,2,2,2,2,2,2,2,null,2,null,null,2,null,2]");
        TreeNode node = MakeTree.stringToTreeNode("[1,3,2,5,3,null,9]");

        System.out.println(new TreeBookPractice().widthOfBinaryTree(node));
    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> m = new HashMap<>();
        q.offer(root);
        m.put(root, 1);
        int curW = 0;
        int maxW = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) start = m.get(node);
                if (i == size - 1) end = m.get(node);
                if (node.left != null) {
                    m.put(node.left, m.get(node) * 2);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    m.put(node.right, m.get(node) * 2 + 1);
                    q.offer(node.right);
                }
            }
            curW = end - start + 1;
            maxW = Math.max(curW, maxW);
        }
        return maxW;
    }
}