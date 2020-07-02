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
        System.out.println(zigzagTreeTraversal.zigzagLevelOrder(tree));
    }

    //region Binary Tree Zigzag Level Order Traversal
    public int[][] zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (A == null) return new int[][]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        boolean b = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            while (len > 0) {

                TreeNode node = queue.poll();
                if (b)
                    integers.add(node.val);
                else
                    integers.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            b = !b;
            list.add(integers);

        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = new int[list.get(i).size()];
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                result[i][j] = list.get(i).get(j);
            }
        }


        return result;
    }

    /*public int[][] zigzagLevelOrder(TreeNode A) {
        List<List<Integer>> list = new ArrayList<>();
        if (A == null) return new int[][]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        boolean b = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (len > 0) {

                TreeNode node = queue.poll();
                if (b)
                    integers.add(node.val);
                else
                    integers.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            b = !b;
            list.add(integers);

        }
        int[][] result = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            int[] num = new int[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                num[j] = list.get(i).get(j);
            }
            result[i] = num;
        }

        return result;
    }*/


    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean b = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (len > 0) {

                TreeNode node = queue.poll();
                if (b)
                    integers.add(node.val);
                else
                    integers.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            b = !b;
            list.add(integers);

        }
        return list;
    }*/
    //endregion

}
