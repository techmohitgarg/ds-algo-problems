package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {


    public static void main(String[] args) {
        TreeNode t1 = MakeTree.stringToTreeNode("[10,5,15,null,null,6,20]");
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(t1));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> integers = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {

                // add Value here in the list
                integers.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            } else {
                list.add(new ArrayList<>(integers));
                integers.clear();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return list;
    }


}