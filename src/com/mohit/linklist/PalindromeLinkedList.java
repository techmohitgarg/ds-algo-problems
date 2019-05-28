package com.mohit.linklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {


    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        //node.next.next.next.next = new ListNode(1);
        System.out.println(list.isPalindrome(node));

    }

    public boolean isPalindrome(ListNode head) {
        return (lPalin(head) == 1) ? true : false;
    }

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }
        int len = 0;
        ListNode node = A;
        while (node != null) {
            len++;
            node = node.next;
        }
        node = A;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < (len / 2)) {
            stack.push(node.val);
            node = node.next;
            i++;

        }

        if (len % 2 != 0) {
            node = node.next;
        }
        while (!stack.isEmpty()) {
            if (!stack.isEmpty() && stack.peek() != node.val) {
                return 0;
            }
            stack.pop();
            node = node.next;
        }
        return 1;
    }


}
