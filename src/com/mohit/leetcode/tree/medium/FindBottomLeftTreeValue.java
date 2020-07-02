package com.mohit.leetcode.tree.medium;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public static void main(String[] args) {
        FindBottomLeftTreeValue treeValue = new FindBottomLeftTreeValue();
        TreeNode node = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left = new TreeNode(1);
        System.out.println(treeValue.findBottomLeftValue(node));
    }

    int left = 0;
    int lastLevel = 0;

    public int findBottomLeftValue(TreeNode root) {
        left = root.val;
        findBottomLeftValue(root, 0, false);
        return left;
    }

    public void findBottomLeftValue(TreeNode root, int level, boolean isLeft) {
        if (root == null) return;

        if (isLeft && lastLevel < level && root.left == null && root.right == null) {
            left = root.val;
            lastLevel = level;
        }

        findBottomLeftValue(root.left, level + 1, true);
        findBottomLeftValue(root.right, level + 1, true);
    }

/*    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int leftValue = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == 0) {
                    leftValue = temp.val;
                }

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return leftValue;
    }*/
    /*public int findBottomLeftValue(TreeNode root) {
        //Base case
        if (root.left == null && root.right == null) return root.val;
        List<Integer> list = new ArrayList<>();
        getBottomLeft(list, root, 0);
        return list.get(list.size() - 1);
    }

    private void getBottomLeft(List<Integer> list, TreeNode root, int k) {
        if (root == null) return;

        if (k >= list.size()) {
            list.add(root.val);
        }
        getBottomLeft(list, root.left, k + 1);
        getBottomLeft(list, root.right, k + 1);
    }*/

}
