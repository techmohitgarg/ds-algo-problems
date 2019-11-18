package com.mohit.leetcode.tree.medium;

import com.mohit.TreeBookPractice;
import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

    public static void main(String[] s) {
        System.out.println(new FindLargestValueInEachTreeRow().largestValues(MakeTree.stringToTreeNode("[1,3,2,5,3,null,9]")));
    }

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            list.add(max);
        }
        return list;
    }
    /*public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        getLargestValue(root, 0, list);
        return list;
    }


    public void getLargestValue(TreeNode root, int val, List<Integer> list) {
        if (root == null) return;
        if (val >= list.size()) {
            list.add(root.val);
        } else {
            list.set(val, Math.max(list.get(val), root.val));
        }

        getLargestValue(root.left, val + 1, list);
        getLargestValue(root.right, val + 1, list);
    }*/
}
