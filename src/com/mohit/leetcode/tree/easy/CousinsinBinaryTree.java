package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTree {


    public static void main(String[] args) {
        /*[1,2,3,null,4,null,5]
        5
        4*/
        TreeNode t1 = MakeTree.stringToTreeNode("[1,null,2,3,null,4,5]");
        System.out.println(new CousinsinBinaryTree().isCousins(t1, 5, 1));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        int dep1 = 1;
        int dep2 = 1;
        TreeNode par1 = null;
        TreeNode par2 = null;

        // Check base case
        if (root.val == x) {
            par1 = root;
        }
        if (root.val == y) {
            par2 = root;
        }

        while (!queue.isEmpty() && (par1 == null || par2 == null)) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (par1 == null) {
                    if ((node.left != null && node.left.val == x) || (node.right != null && node.right.val == x)) {
                        par1 = node;
                        dep1++;
                    }
                }
                if (par2 == null) {
                    if ((node.left != null && node.left.val == y) || (node.right != null && node.right.val == y)) {
                        par2 = node;
                        dep2++;
                    }
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            } else {
                if (!queue.isEmpty()) {
                    if (par1 == null) {
                        dep1++;
                    }
                    if (par2 == null) {
                        dep2++;
                    }
                    queue.add(null);

                }
            }
        }

        if (dep1 != dep2) return false;
        else if (par1 == par2) return false;
        return true;
    }


}