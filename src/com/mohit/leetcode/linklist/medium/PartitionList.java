package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class PartitionList {

    public static void main(String[] args) {
        PartitionList list = new PartitionList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);
        PrintLinkList.print(list.partition(l1, 3));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode node = new ListNode(0);
        ListNode before = node;
        ListNode node_ = new ListNode(0);
        ListNode after = node_;
        ListNode iter = head;
        while (iter != null) {
            if (iter.val < x) {
                before.next = new ListNode(iter.val);
                before = before.next;
            } else {
                after.next = new ListNode(iter.val);
                after = after.next;
            }
            iter = iter.next;
        }

        before.next = node_.next;
        return node.next;
    }
    /*public ListNode partition(ListNode head, int x) {
        if (head == null) return head;

        ListNode lessThan = new ListNode(-1);
        ListNode node = lessThan;
        ListNode itr = new ListNode(-1);
        itr.next = head;
        ListNode greater = itr;
        while (greater.next != null) {
            if (greater.next.val < x) {
                // Add Small number in linked list
                node.next = new ListNode(greater.next.val);
                node = node.next;

                // Than remove small number from main list
                greater.next = greater.next.next;
            } else {
                greater = greater.next;
            }
        }

        node.next = itr.next;
        return lessThan.next;
    }*/
}
