package com.mohit.linklist;

import java.util.List;

public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList sortList = new InsertionSortList();
        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(0);
        l1.next.next.next.next.next = new ListNode(0);
        PrintLinkList.print(sortList.insertionSortList(l1));
    }


    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        ListNode prev = new ListNode(0);
        ListNode listNode = prev;
        ListNode next;
        while (node != null) {
            next = node.next;
            while (listNode.next != null && listNode.next.val < node.val) {
                listNode = listNode.next;
            }

            node.next = listNode.next;
            listNode.next = node;
            listNode = prev;
            node = next;
        }

        return prev.next;
    }
}
