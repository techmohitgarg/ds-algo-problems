package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;

import java.util.Stack;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        AddTwoNumbersII numbersII = new AddTwoNumbersII();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        print(numbersII.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode node = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            if (!s1.isEmpty()) {
                carry += s1.pop();
            }
            if (!s2.isEmpty()) {
                carry += s2.pop();
            }
            ListNode temp = new ListNode(carry % 10);
            temp.next = node;
            node = temp;
            carry /= 10;
        }

        return node;
    }
}
