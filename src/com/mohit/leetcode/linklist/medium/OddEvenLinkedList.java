package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        OddEvenLinkedList linkedList = new OddEvenLinkedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        PrintLinkList.print(linkedList.oddEvenList(l1));
    }


    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode node = even;
        while (odd != null && odd.next != null && node.next != null) {
            odd.next = odd.next.next;
            node.next = node.next.next;
            odd = odd.next;
            node = node.next;
        }
        odd.next = even;
        return head;
    }

    /*public ListNode oddEvenList(ListNode head) {

        if (head == null||head.next==null||head.next.next==null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;
        while (odd != null && even != null && even.next != null) {


            // Set Next Odd Position than should be next to even number
            odd.next = even.next;
            // Now move next odd that will be next to even number
            odd = even.next;

            // If odd.next is null means there is not even number than break the loop
            if (odd.next == null) {
                even.next = null;
                odd.next = evenStart;
                break;
            }

            // set the next even number that should be odd next number
            even.next = odd.next;
            //Move to next even number that should be odd next number
            even = odd.next;
        }

        // than add the even list next to the last node off odd list
        odd.next = evenStart;

        return head;
    }*/
    /*public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode even = new ListNode(-1);
        ListNode itrEven = even;

        ListNode curr = head;
        while (curr.next != null && curr.next.next != null) {
            itrEven.next = new ListNode(curr.next.val);
            itrEven = itrEven.next;
            curr.next = curr.next.next;
            curr = curr.next;

        }

        if (curr.next != null) {
            itrEven.next = new ListNode(curr.next.val);
        }
        // Add Even Node after odd nodes
        curr.next = even.next;
        return head;
    }*/
}
