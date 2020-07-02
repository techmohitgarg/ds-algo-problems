package com.mohit.leetcode.tree.medium;


import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;


public class ClosestLeafInABinaryTree {
    TreeNode lastNode = null;
    TreeNode head = null;

    public static void main(String[] args) {
        ClosestLeafInABinaryTree sol = new ClosestLeafInABinaryTree();
        TreeNode root1 = MakeTree.stringToTreeNode("[1,2,3,4,null,null,null,5,null,6]".replace("#", "null"));

        System.out.println(sol.findClosest(root1, 2));
    }

    int answer;

    public int findClosest(TreeNode root, int key) {
        answer = Integer.MAX_VALUE;
        helper(root, key, new ArrayList<TreeNode>());
        return answer;
    }

    private void helper(TreeNode root, int key, ArrayList<TreeNode> treeNodes) {
        if (root == null) return;
        else if (root.val != key) {
            treeNodes.add(root);
            helper(root.left, key, treeNodes);
            helper(root.right, key, treeNodes);
            treeNodes.remove(treeNodes.size() - 1);
        } else {

            answer = minLeafNodeOfTheTree(root);

            int len = treeNodes.size();
            for (int i = len - 1; i >= 0; i--) {
                int minLeafNode = minLeafNodeOfTheTree(treeNodes.get(i));
                answer = Math.min(answer, (len - i) + minLeafNode);
            }
        }
    }


    private int minLeafNodeOfTheTree(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.min(minLeafNodeOfTheTree(root.left), minLeafNodeOfTheTree(root.right));
    }

}