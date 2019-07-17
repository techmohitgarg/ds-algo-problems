package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList node = new RemoveNthNodeFromEndofList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        PrintLinkList.print(node.removeNthFromEnd(l1, 4));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        int a = 1;
        while (node.next != null) {
            a++;
            node = node.next;
        }
        int i = 0;
        node = head;
        if (n <= a) {
            if (n == a) {
                head = head.next;
            } else {
                while (i < a && (a - i) - 1 != n) {
                    i++;
                    node = node.next;
                }
                node.next = node.next.next;
            }
        }
        return head;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) return head;

        ListNode dummy = head;
        int size = 0;
        while (dummy != null) {
            dummy = dummy.next;
            size++;
        }
        dummy = head;
        int i = 1;
        if (n <= size) {
            if (n == size) {
                head = head.next;
            } else {
                while (dummy.next != null && (size - i) > n) {
                    dummy = dummy.next;
                    i++;
                }
                dummy.next = dummy.next.next;
            }
        }
        return head;
    }
}
