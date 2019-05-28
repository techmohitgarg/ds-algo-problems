package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        BinaryTreePaths zigzagTreeTraversal = new BinaryTreePaths();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        System.out.println(zigzagTreeTraversal.binaryTreePaths(tree));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        printPaths(list, new ArrayList<>(), root);
        return list;
    }


    public void printPaths(List<String> list, List<Integer> integers, TreeNode root) {
        if (root == null) {
            return;
        }
        integers.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < integers.size(); i++) {
                sb.append(integers.get(i) + "->");
            }
            if (sb.length() > 2) {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            list.add(sb.toString());

        }
        printPaths(list, integers, root.left);
        printPaths(list, integers, root.right);
        integers.remove(integers.size() - 1);
    }


}
