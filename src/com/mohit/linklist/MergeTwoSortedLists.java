package com.mohit.linklist;

import java.util.List;

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
            node.next = mergeTwoLists(l1.next, l2);
        } else {
            node = new ListNode(l2.val);
            node.next = mergeTwoLists(l1, l2.next);
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
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // check if both are empty
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(-1);
        ListNode iter = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        while (l1 != null) {
            node.next = new ListNode(l1.val);
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            node.next = new ListNode(l2.val);
            l2 = l2.next;
            node = node.next;
        }
        return iter.next;
    }
}
