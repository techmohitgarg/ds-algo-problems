package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

public class ConvertSortedListToBinarySearchTree {


    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree sol = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode root = sol.sortedListToBST(head);
        System.out.println(root);
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }


}
