package com.mohit.leetcode.linklist.easy;

import com.mohit.linklist.ListNode;

public class DeleteNodeLinkedList {

    public static void main(String[] args) {
        DeleteNodeLinkedList linkedList = new DeleteNodeLinkedList();

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
