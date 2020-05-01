package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

public class SplitCircularLinkedListIntoTwoHalves {
    static ListNode head = null;
    ListNode tail = null;

    public static void main(String[] args) {
        SplitCircularLinkedListIntoTwoHalves sol = new SplitCircularLinkedListIntoTwoHalves();
    }

    public ListNode splitCircularLinkedList(ListNode head) {
        if (head == null) return head;

        int len = 1;
        ListNode curr = head;
        while (curr.next != head) {
            len++;
            curr = curr.next;
        }
        curr = head;
        // Find the length
        len = (len % 2 == 0) ? (len / 2) : (len / 2) + 1;
        ListNode tempHead = head;
        ListNode firstPart = null;
        while (len > 0) {
            firstPart = curr;
            curr = curr.next;
            len--;
        }
        // Set the perv value to first value
        firstPart.next = head;

        ListNode second = curr;

        while (second.next != head) {
            second = second.next;
        }
        second.next = curr;

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
