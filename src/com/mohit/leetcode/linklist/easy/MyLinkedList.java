package com.mohit.leetcode.linklist.easy;

import com.mohit.leetcode.linklist.ListNode;

public class MyLinkedList {


    ListNode head = null;
    ListNode tail = null;
    int len = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = new ListNode(-1);
        tail = head;
        len = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= len)
            return -1;

        ListNode node = head.next;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode data = new ListNode(val);
        data.next = head.next;
        head.next = data;
        len++;
        if (tail.next != null) {
            tail = tail.next;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
        len++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > len) {
            return;
        }
        ListNode dummy = new ListNode(val);
        ListNode node = head;
        while (index > 0) {
            index--;
            node = node.next;
        }

        dummy.next = node.next;
        node.next = dummy;
        len++;
        if (tail.next != null) {
            tail = tail.next;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= len) return;

        ListNode iter = head;
        while (index > 0) {
            iter = iter.next;
            index--;
        }

        if (iter.next == tail) {
            tail = iter;
        }
        iter.next = iter.next.next;
        len--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */