package com.mohit.leetcode.linklist;


import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.List;

public class LinkedListSolution {

    public static void main(String[] args) {
        LinkedListSolution solution = new LinkedListSolution();
        ListNode root = LinkedUtil.makeListNode(new int[]{6, 5, 3, 1, 8, 7, 2, 4});
        solution.insertionSortList(root);
    }

    public ListNode insertionSortList(ListNode head) {
        //Base Case
        if (head == null || head.next == null) return head;

        ListNode prev = null;

        ListNode curr = head;
        while (curr != null) {
            ListNode itr = prev;
            while (itr != null && itr.val < curr.val) {
                itr = itr.next;
            }

            ListNode next = curr.next;
            ListNode temp = itr.next;
            itr.next = curr;
            itr.next.next = temp;
            curr = next;
        }
        return prev.next;
    }

}