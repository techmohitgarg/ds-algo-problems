package com.mohit.leetcode.linklist.easy;

import com.mohit.linklist.ListNode;
import com.mohit.linklist.PrintLinkList;

public class RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList list = new RemoveDuplicatesfromSortedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next = new ListNode(3);
        PrintLinkList.print(list.deleteDuplicates1(l1));
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }
        head.next = deleteDuplicates1(head.next);
        while (head != null && head.next != null && head.val == head.next.val) {
            head.next = head.next.next;
        }
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode iter = head;
        while (iter != null && iter.next != null) {
            while (iter != null && iter.next != null && iter.val == iter.next.val) {
                iter.next = iter.next.next;
            }
            iter = iter.next;
        }
        return head;
    }
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode iter = head;
        while (iter.next != null) {
            if (iter.val == iter.next.val) {
                iter.next = iter.next.next;
            } else {
                iter = iter.next;
            }
        }
        return head;
    }
}
