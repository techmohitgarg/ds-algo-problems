package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class DeleteAlternateNodesofLinkedList {

    public static void main(String[] args) {
        DeleteAlternateNodesofLinkedList sol = new DeleteAlternateNodesofLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = sol.deleteAlternateNodes(head);
        PrintLinkList.print(result);

    }


    public ListNode deleteAlternateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = next.next;
        // FreeUp memory here
        next = null;
        deleteAlternateNodes(head.next);
        return head;
    }

    /*public ListNode deleteAlternateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        while (prev != null && prev.next != null) {
            ListNode temp = prev.next;
            prev.next = prev.next.next;
            temp = null;
            prev = prev.next;
        }
        return head;
    }*/

    /*public ListNode deleteAlternateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode curr = node;
        int i = 1;
        while (curr.next != null) {
            if (i % 2 == 0) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
            i++;
        }
        return node.next;
    }*/

}
