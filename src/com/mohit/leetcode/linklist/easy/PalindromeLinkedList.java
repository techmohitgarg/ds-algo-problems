package com.mohit.leetcode.linklist.easy;

import com.mohit.linklist.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {


    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        System.out.println(list.isPalindrome(node));

    }

    public boolean isPalindrome(ListNode A) {
        if (A == null || A.next == null) {
            return true;
        }
        int len = 0;
        ListNode curr = A;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        curr = A;
        ListNode prev = null;
        ListNode next;

        int i = 0;
        while (i < (len / 2)) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        if (len % 2 != 0) {
            curr = curr.next;
        }

        ListNode part1 = prev;
        ListNode part2 = curr;
        while (part1 != null && part2 != null) {
            if (part1.val != part2.val) return false;
            part1 = part1.next;
            part2 = part2.next;
        }
        return true;
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

    /*public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        List<Integer> str = new ArrayList<>();
        ListNode a = head;
        while (a != null) {
            str.add(a.val);
            a = a.next;
        }

        int l = 0;
        int r = str.size() - 1;
        while (l < r) {
            if (str.get(l).intValue() != str.get(r).intValue()) return false;
            l++;
            r--;
        }

        return true;
    }*/
}
