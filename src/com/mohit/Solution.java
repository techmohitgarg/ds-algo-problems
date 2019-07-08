package com.mohit;

import com.mohit.linklist.ListNode;
import com.mohit.linklist.PrintLinkList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        PrintLinkList.print(main.reverseBetween(node, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n || m > n) return head;
        int start = 1;

        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode curr = listNode;
        while (start < m && curr != null) {
            curr = curr.next;
            start++;
        }

        ListNode prev = null;
        ListNode next = null;
        ListNode node = curr.next;
        while (node != null && start <= n) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            start++;
        }

        ListNode r = prev;
        while (r.next != null) {
            r = r.next;
        }
        r.next = next;
        curr.next = prev;

        return listNode.next;
    }


}
