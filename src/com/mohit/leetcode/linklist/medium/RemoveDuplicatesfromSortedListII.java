package com.mohit.leetcode.linklist.medium;

import com.mohit.linklist.ListNode;
import com.mohit.linklist.PrintLinkList;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListII sortedListII = new RemoveDuplicatesfromSortedListII();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);
        PrintLinkList.print(sortedListII.deleteDuplicates(l1));
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && pre.next.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return node.next;
    }

    /*public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> set = new HashMap<>();
        ListNode iter = head;

        while (iter != null) {
            set.put(iter.val, set.getOrDefault(iter.val, 0) + 1);
            iter = iter.next;
        }
        ListNode node = new ListNode(0);
        ListNode listNode = node;


        iter = head;
        while (iter != null) {
            if (set.get(iter.val) == 1) {
                listNode.next = new ListNode(iter.val);
                listNode = listNode.next;
            }
            iter = iter.next;
        }

        return node.next;
    }*/
}
