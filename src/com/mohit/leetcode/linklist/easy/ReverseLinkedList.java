package com.mohit.leetcode.linklist.easy;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList elements = new ReverseLinkedList();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        PrintLinkList.print(elements.reverseList(headA));

    }

    /*Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL*/
    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode current = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return current;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head, prev = null, next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head, next;
        while (current.next != null) {
            next = current.next;
            current.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }
}
