package com.mohit.leetcode.tree.medium;

import com.mohit.TreeBookPractice;
import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {

    public static void main(String[] s) {
        System.out.println(new BinaryTreeRightSideView().rightSideView(MakeTree.stringToTreeNode("[1,2,3,null,5,null,4]")));
        System.out.println(new BinaryTreeRightSideView().rightSideView(MakeTree.stringToTreeNode("[1,2,null,4,5,null,null,6,7]")));
        System.out.println(new BinaryTreeRightSideView().rightSideView(MakeTree.stringToTreeNode("[1,2,null,4,5,null,null,6,null,7]")));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // Base Case
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {

                // if the next node is null means this is the last node which need to add in the list
                if (queue.peek() == null) {
                    list.add(node.val);
                }

                // Add the left and right node the in the queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            } else {

                if (!queue.isEmpty()) {
                    queue.add(null);
                }

            }

        }
        return list;
    }

    //region Binary Tree Right Side View
    /*public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideViewNodeList(root, list, 0);
        return list;
    }

    private void rightSideViewNodeList(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;

        if (list.size() <= level) {
            list.add(root.val);
        }

        rightSideViewNodeList(root.right, list, level + 1);
        rightSideViewNodeList(root.left, list, level + 1);
    }*/
    //endregion
    /*public List<Integer> rightSideView1(TreeNode root) {
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
    }*/


    /*public void rightSide(List<Integer> list, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level >= list.size()) {
            list.add(root.val);
        }
        rightSide(list, root.right, level + 1);
        rightSide(list, root.left, level + 1);
    }*/
}
