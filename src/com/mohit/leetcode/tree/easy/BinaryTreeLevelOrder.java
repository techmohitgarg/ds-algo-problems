package com.mohit.leetcode.tree.easy;

import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrder {

    public static void main(String[] args) {
        BinaryTreeLevelOrder treeLevelOrder = new BinaryTreeLevelOrder();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        System.out.println(treeLevelOrder.levelOrderBottom(tree));
    }


    //region levelOrderBottom using iteration

    /**
     * @param root tree
     * @return list of all level nodes
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(0, list);
        }
        return result;
    }
    //endregion
}
