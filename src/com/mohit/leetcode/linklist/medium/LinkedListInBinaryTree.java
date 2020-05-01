package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class LinkedListInBinaryTree {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkedListInBinaryTree sol = new LinkedListInBinaryTree();
        //4,2,8
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);
        TreeNode node = MakeTree.stringToTreeNode("[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]");
        System.out.println(sol.isSubPath(head, node));
    }


    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null || root == null) return false;
        ListNode curr = head;
        if (isPath(curr, root))
            return true;
        return isSubPath(curr, root.left) || isSubPath(curr, root.right);
    }


    public boolean isPath(ListNode head, TreeNode root) {
        if (head == null && root == null) return true;
        if (head == null) return true;
        if (root == null) return false;
        if (head.val != root.val) return false;
        return isPath(head.next, root.left) || isPath(head.next, root.right);
    }


}
