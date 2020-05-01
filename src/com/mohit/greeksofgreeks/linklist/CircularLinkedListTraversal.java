package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

public class CircularLinkedListTraversal {
    static ListNode head = null;
    ListNode tail = null;
    public static void main(String[] args) {
        CircularLinkedListTraversal sol = new CircularLinkedListTraversal();
        int[] arr = new int[]{12, 56, 2, 11};

        for (int i = 0; i < arr.length; i++) {
            sol.circularLinkedListUsingTail(arr[i]);
        }
        System.out.println(head);
    }

    // Without using tail pointer
    public ListNode circularLinkedList(ListNode head, int data) {
        ListNode node = new ListNode(data);
        ListNode curr = head;
        node.next = head;

        if (curr != null) {
            // Add the first node into the last node
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = node;
        } else {
            node.next = node;
        }
        head = node;
        return head;
    }

    public void circularLinkedListUsingTail(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        tail.next = head;
    }


}
