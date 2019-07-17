package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class RotateList {

    public static void main(String[] args) {
        RotateList main = new RotateList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        PrintLinkList.print(main.rotateRight(node, 2));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int len = 0;
        ListNode iter = head;
        while (iter != null) {
            len++;
            iter = iter.next;
        }

        int rotate = k % len;
        if (rotate == 0) {
            return head;
        }
        iter = head;
        int i = 0;
        while (i < (len - rotate) - 1) {
            iter = iter.next;
            i++;
        }
        ListNode node = iter.next;
        iter.next = null;
        ListNode listNode = node;
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = head;
        head = node;
        return head;
    }
    /*public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        k = k % (len);
        if (k == 0) return head;
        int step = (len) - k;
        ListNode p = head;
        while (step-- > 1) {
            p = p.next;
        }
        curr.next = head;
        head = p.next;
        p.next = null;
        return head;
    }*/
}
