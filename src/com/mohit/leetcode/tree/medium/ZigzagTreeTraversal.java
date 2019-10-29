package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTreeTraversal {

    public static void main(String[] args) {
        ZigzagTreeTraversal zigzagTreeTraversal = new ZigzagTreeTraversal();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(zigzagTreeTraversal.zigzagTree(tree));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> integers = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean b = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (b)
                    integers.add(node.val);
                else
                    integers.add(0, node.val);


                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {

                list.add(new ArrayList<>(integers));
                integers.clear();
                if (!queue.isEmpty()) {
                    queue.add(null);
                    b = !b;
                }
            }
        }
        return list;
    }

    public List<Integer> zigzagTree(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isleft = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (len > 0) {
                TreeNode node = queue.poll();
                if (isleft) {
                    integers.add(node.val);
                } else {
                    integers.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                len--;
            }
            isleft = !isleft;
            list.addAll(new ArrayList<>(integers));
        }
        return list;
    }

}
