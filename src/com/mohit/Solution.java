package com.mohit;

import com.mohit.leetcode.linklist.ListNode;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);


        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode result = sol.mergeTwoLists(node, head2);

        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        else if (l1 == null) return l2;

        else if (l2 == null) return l1;

        else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists_(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        if (headA == null) return headB;
        if (headB == null) return headA;

        ListNode head = new ListNode(0);
        ListNode itr = head;

        ListNode a = headA;
        ListNode b = headB;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                itr.next = new ListNode(a.val);
                a = a.next;
            } else {
                itr.next = new ListNode(b.val);
                b = b.next;
            }
            itr = itr.next;
        }

        if (a == null) {
            itr.next = b;
        }
        if (b == null) {
            itr.next = a;
        }

        return head.next;
    }

}