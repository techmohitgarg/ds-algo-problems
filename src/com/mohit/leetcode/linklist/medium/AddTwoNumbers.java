package com.mohit.leetcode.linklist.medium;

import com.mohit.linklist.ListNode;
import com.mohit.linklist.PrintLinkList;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers numbers = new AddTwoNumbers();
        //2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        //5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        PrintLinkList.print(numbers.addTwoNumbers(l1, l2));

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode(0);
        ListNode iter = sumNode;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            iter.next = new ListNode(carry % 10);
            carry /= 10;
            iter = iter.next;
        }
        return sumNode.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p, dummy = new ListNode(0);
        p = dummy;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            carry /= 10;
            p = p.next;
        }
        return dummy.next;
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return l1;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node = new ListNode(0);
        ListNode iter = node;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            iter.next = new ListNode(sum % 10);
            iter = iter.next;
            carry = sum / 10;
        }
        if (carry == 1) {
            iter.next = new ListNode(carry);
        }
        return node.next;
    }
}
