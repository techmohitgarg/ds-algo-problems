package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    static class BSTIterator {
        List<Integer> list = new ArrayList<>();
        int i = 0;

        public BSTIterator(TreeNode root) {
            inOrder(list, root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (hasNext()) {
                int num = list.get(i);
                i++;
                return num;
            }
            return -1;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return (i < list.size());
        }

        private void inOrder(List<Integer> list, TreeNode root) {
            if (root == null) return;
            inOrder(list, root.left);
            list.add(root.val);
            inOrder(list, root.right);
        }
    }


}