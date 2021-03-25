package com.mohit.leetcode.linklist.medium;

class FrontMiddleBackQueue {
    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    ListNode head;
    ListNode tail;
    int len = 0;

    public FrontMiddleBackQueue() {
        len = 0;
        head = null;
        tail = null;
    }

    public void pushFront(int val) {
        ListNode node = new ListNode(val);
        if (!isEmpty()) {
            node.next = head;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
        len++;
    }

    public void pushMiddle(int val) {
        if (isEmpty()) {
            pushFront(val);
            return;
        }
        ListNode node = new ListNode(val);
        int middle = len / 2;
        ListNode itr = head;

        if (middle == 0 || len == 1) {
            pushFront(val);
            return;
        } else {
            ListNode prev = null;
            while (itr != null && middle > 0) {
                prev = itr;
                itr = itr.next;
                middle--;
            }
            node.next = itr;
            prev.next = node;
            len++;
        }

    }

    public void pushBack(int val) {
        if (isEmpty()) {
            pushFront(val);
            return;
        }
        ListNode node = new ListNode(val);
        tail.next = node;
        tail = tail.next;
        len++;
    }

    public int popFront() {
        if (isEmpty())
            return -1;

        //Safe check here
        if (head == null) return -1;

        int val = head.val;
        // remove the front node
        head = head.next;

        if (head == null) {
            tail = null;
        } else if (head.next == null) {
            tail = head;
        }

        len--;

        return val;
    }

    public int popMiddle() {
        if (isEmpty())
            return -1;

        int middle = (len % 2 == 0) ? len / 2 - 1 : len / 2;
        if (middle == 0 || len == 1) {
            return popFront();
        } else {
            ListNode itr = head;
            ListNode prev = null;
            while (itr != null && itr.next != null && middle > 0) {
                prev = itr;
                itr = itr.next;
                middle--;
            }
            int val = itr.val;
            prev.next = itr.next;

            len--;

            return val;
        }
    }

    public int popBack() {
        if (isEmpty())
            return -1;

        if (len == 1) {
            return popFront();
        }

        ListNode itr = head;
        ListNode prev = null;
        while (itr != null && itr.next != null) {
            prev = itr;
            itr = itr.next;
        }

        int val = itr.val;
        prev.next = null;
        tail = prev;

        len--;
        return val;
    }

    private boolean isEmpty() {
        return len <= 0;
    }
}