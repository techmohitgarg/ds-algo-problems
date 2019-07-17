package com.mohit;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);

        ListNode two = new ListNode(1);
        two.next = new ListNode(2);
        two.next.next = new ListNode(3);

        ListNode three = new ListNode(1);
        three.next = new ListNode(2);
        three.next.next = new ListNode(3);

        ListNode[] nodes = new ListNode[3];
        nodes[0] = one;
        nodes[1] = two;
        nodes[2] = three;
        PrintLinkList.print(main.mergeKLists(nodes));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode node = lists[0];
        int i = 1;
        while (i < lists.length) {
            node = mergeTwoLists(node, lists[i]);
            i++;
        }
        return node;
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        // get center
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node = new ListNode(0);
        ListNode iter = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iter.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                iter.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            iter = iter.next;
        }
        if (l1 != null) {
            iter.next = l1;
        } else if (l2 != null) {
            iter.next = l2;
        }
        return node.next;
    }

}
