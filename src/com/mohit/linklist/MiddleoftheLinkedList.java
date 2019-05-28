package com.mohit.linklist;

public class MiddleoftheLinkedList {

    public static void main(String[] args) {
         MiddleoftheLinkedList list = new MiddleoftheLinkedList();

    }

    public ListNode middleNode(ListNode head) {
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
    }
}
