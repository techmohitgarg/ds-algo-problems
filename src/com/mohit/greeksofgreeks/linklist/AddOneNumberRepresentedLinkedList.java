package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

public class AddOneNumberRepresentedLinkedList {


    public static void main(String[] args) {
        AddOneNumberRepresentedLinkedList sol = new AddOneNumberRepresentedLinkedList();
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        sol.addedOne(head);
    }


    public ListNode addedOne(ListNode head) {
        int res = addingOneUsingRecurse(head);
        if (res == 1) {
            ListNode node = new ListNode(res);
            node.next = head;
            head = node;
        }
        return head;
    }

    public int addingOneUsingRecurse(ListNode head) {
        if (head == null) return 1;

        int res = head.val + addingOneUsingRecurse(head.next);
        head.val = res % 10;
        return res / 10;
    }

    public ListNode addingOne(ListNode head) {
        if (head == null) {
            return head;
        }

        // Reverse the list
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // After reverse the list assign list to curr
        head = prev;
        curr = head;
        // Carry 1 because we have to add 1 in the number
        int carry = 1;
        ListNode tail = null;
        while (curr != null) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            curr = curr.next;
            if (curr != null && curr.next == null) {
                tail = curr;
            }
        }
        if (carry == 1) {
            tail.next = new ListNode(carry);
        }

        // Again reverse the list
        prev = null;
        curr = head;
        next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        return head;

    }


}

