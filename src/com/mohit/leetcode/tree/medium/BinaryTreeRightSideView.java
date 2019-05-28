package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {

    public static void main(String[] s) {

    }

    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSide(list, root, 0);
        return list;
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean iadd = false;
            while (size > 0) {
                TreeNode temp = queue.poll();
                if (!iadd) {
                    if (temp != null) {
                        list.add(temp.val);
                        iadd = true;
                    }
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                size--;
            }

        }
        return list;
    }


    public void rightSide(List<Integer> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level >= list.size()) {
            list.add(root.val);
        }
        rightSide(list, root.right, level + 1);
        rightSide(list, root.left, level + 1);
    }
}
