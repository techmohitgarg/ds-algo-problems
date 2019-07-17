package com.mohit.leetcode.linklist.easy;

import com.mohit.leetcode.linklist.ListNode;

public class MiddleoftheLinkedList {

    public static void main(String[] args) {
        MiddleoftheLinkedList list = new MiddleoftheLinkedList();
        list.middleNode(null);

    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /*public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        node = head;
        int i = 0;
        size = (size % 2 == 0) ? (size / 2) + 1 : (size / 2);
        while (i < size) {
            node = node.next;
            i++;
        }
        return node;
    }*/

}
