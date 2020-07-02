package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeIterator {


    public static void main(String[] args) {
        TreeNode t1 = MakeTree.stringToTreeNode("[7,3,15,null,null,9,20]");
        BSTIterator iterator = new BSTIterator(t1);
        iterator.next();    // return 3
        iterator.next();    // return 7
        iterator.hasNext(); // return true
        iterator.next();    // return 9
        iterator.hasNext(); // return true
        iterator.next();    // return 15
        iterator.hasNext(); // return true
        iterator.next();    // return 20
        iterator.hasNext(); // return false
    }

    //region Binary Search Tree Iterator
    static class BSTIterator {

        Queue<Integer> queue = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            inOrder(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (queue.isEmpty()) return -1;
            return queue.poll().intValue();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        private void inOrder(TreeNode node) {
            if (node == null) return;
            inOrder(node.left);
            queue.add(node.val);
            inOrder(node.right);
        }
    }
    //endregion


}