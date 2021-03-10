package com.mohit.leetcode.linklist;

public class LinkedUtil {

    public static ListNode makeListNode(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode itr = head;
        for (int i = 1; i < nums.length; i++) {
            itr.next = new ListNode(nums[i]);
            itr = itr.next;
        }
        return head;
    }

    public static Node makeNode(int[] nums) {
        if (nums.length == 0) return null;
        Node head = new Node(nums[0]);
        Node itr = head;
        for (int i = 1; i < nums.length; i++) {
            itr.next = new Node(nums[i]);
            itr = itr.next;
        }
        return head;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode next = null;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();

    }

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();

    }

    public static void makeLoop(Node head, int x) {
        if (x == 0) return;

        int currentNode = 1;
        Node curr = head;
        Node last = head;
        while (currentNode < x) {
            curr = curr.next;
            currentNode++;
        }

        while (last.next != null) {
            last = last.next;
        }
        last.next = curr;
    }
}
