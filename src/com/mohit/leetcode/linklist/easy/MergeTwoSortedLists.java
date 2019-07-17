package com.mohit.leetcode.linklist.easy;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class MergeTwoSortedLists {


    public static void main(String[] args) {
        //1->2->4, 1->3->4
        MergeTwoSortedLists lists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        PrintLinkList.print(lists
                .mergeTwoLists_two(l1, l2));
    }

    public ListNode mergeTwoLists_one(ListNode l1, ListNode l2) {
        // check if both are empty
        ListNode node = null;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            node = new ListNode(l1.val);
            node.next = mergeTwoLists_one(l1.next, l2);
        } else {
            node = new ListNode(l2.val);
            node.next = mergeTwoLists_one(l1, l2.next);
        }
        return node;
    }

    public ListNode mergeTwoLists_two(ListNode l1, ListNode l2) {
        // check if both are empty
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists_two(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_two(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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
