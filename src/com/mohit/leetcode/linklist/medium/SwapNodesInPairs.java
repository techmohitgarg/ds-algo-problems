package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs nodes = new SwapNodesInPairs();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        PrintLinkList.print(nodes.swapPairs(l1));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode newReversed = swapPairs(head.next.next);
        head.next = newReversed;
        newHead.next = head;
        return newHead;
    }

    public void pairWiseSwap(ListNode node) {
        if (node == null || node.next == null) return;

        ListNode temp = node.next.next;
        node.next.next = node;
        node = node.next;
        node.next.next = temp;

        ListNode curr = node.next;

        while (curr.next != null && curr.next.next != null) {
            ListNode newHead = curr.next.next;
            curr.next.next = curr.next.next.next;
            newHead.next = curr.next;
            curr.next = newHead;
            curr = curr.next.next;
        }

        PrintLinkList.print(node);
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int temp = head.val;
        head.val = head.next.val;
        head.next.val = temp;
        swapPairs1(head.next.next);
        return head;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode node = new ListNode(0);
        ListNode iter = node;
        while (current != null && current.next != null) {
            iter.next = new ListNode(current.next.val);
            iter = iter.next;
            iter.next = new ListNode(current.val);
            iter = iter.next;

            current = current.next.next;
        }
        if (current != null) {
            iter.next = current;
        }
        return node.next;
    }
}
