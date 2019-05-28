package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsBinaryTree {

    public static void main(String[] s) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            int i = 0;
            double sum = 0;
            while (i < size) {
                TreeNode node = treeNodes.poll();
                sum += node.val;
                if (node.left != null) {
                    treeNodes.add(node.left);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                }
                i++;
            }
            list.add(sum / size);
        }
        return list;

    }

}
