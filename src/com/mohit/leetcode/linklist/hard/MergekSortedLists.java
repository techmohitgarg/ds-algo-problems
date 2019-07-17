package com.mohit.leetcode.linklist.hard;

import com.mohit.leetcode.linklist.easy.MergeTwoSortedLists;
import com.mohit.leetcode.linklist.ListNode;

public class MergekSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists lists = new MergeTwoSortedLists();
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        ListNode node = lists[0];
        ListNode listNode = node;
        for (int i = 1; i < lists.length; i++) {
            while (listNode.next != null) {
                listNode = listNode.next;
            }
            if (listNode.next == null) {
                if (lists[i] != null)
                    listNode.next = lists[i];
            }
        }
        node = sortList(node);
        return node;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        // get center
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode(0);
        ListNode iter = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iter.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                iter.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            iter = iter.next;
        }
        if (l1 != null) {
            iter.next = l1;
        } else if (l2 != null) {
            iter.next = l2;
        }
        return node.next;
    }
}
