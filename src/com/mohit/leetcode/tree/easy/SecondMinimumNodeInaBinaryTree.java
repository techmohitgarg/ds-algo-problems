package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SecondMinimumNodeInaBinaryTree {


    public static void main(String[] args) {
        TreeNode t1 = MakeTree.stringToTreeNode("[2,2,2147483647]");
        System.out.println(new SecondMinimumNodeInaBinaryTree().findSecondMinimumValue(t1));
    }

    public int findSecondMinimumValue(TreeNode root) {
        Integer first = null, second = first;
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.poll();
                int val = node.val;

                if (first == null) {
                    first = val;
                } else {
                    first = Math.min(first, val);
                }

                if (val > first) {
                    if (second == null) {
                        second = val;
                    } else {
                        second = Math.min(second, val);
                    }
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                len--;
            }

        }
        if (second == null || (first == second)) return -1;
        return second;
    }

    /*public int findSecondMinimumValue(TreeNode root) {
        Integer first = null, second = first;
        if (root == null) return -1;

        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        first = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            first = Math.min(first, list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > first) {
                if (second == null)
                    second = list.get(i);
                else
                    second = Math.min(second, list.get(i));
            }
        }
        if (second == null || (first == second)) return -1;
        return second;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }*/

}
