package com.mohit.leetcode.linklist.easy;

import com.mohit.leetcode.linklist.ListNode;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        RemoveLinkedListElements elements = new RemoveLinkedListElements();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(2);
        headA.next.next.next = new ListNode(1);
        print(elements.removeElements(headA, 2));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }

        }
        return head;
    }
}
