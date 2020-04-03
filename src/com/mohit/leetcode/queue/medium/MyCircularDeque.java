package com.mohit.leetcode.queue.medium;
public class MyCircularDeque {
    int sz = 0;
    int len = 0;
    public class Node {
        public int val;
        public Node next;
        public Node(int x) {
            val = x;
            next = null;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    Node head = null;
    Node tail = null;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    /**
     * insertFront : O(1)
     * insertLast : O(1)
     * deleteFront : O(1)
     * deleteLast : O(N)
     * getFront : O(1)
     * getRear : O(1)
     * isEmpty : O(1)
     * isFull : O(1)
     */

    public MyCircularDeque(int k) {
        this.len = k;
    }
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node newest = new Node(value);
        if (head != null) {
            newest.setNext(head);
        }
        head = newest;
        if (tail == null) {
            tail = newest;
        }
        sz++;
        return true;
    }
    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;

        Node newest = new Node(value);
        if (head == null) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        sz++;
        return true;
    }
    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = head.next;
        sz--;
        if (sz == 0) {
            tail = null;
        }
        return true;
    }
    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node itr = head;
        while (itr != null && itr.next != null && itr.next.next != null) {
            itr = itr.next;
        }
        sz--;
        if (sz == 0) {
            tail = null;
            head = null;
        } else {
            tail = itr;
            itr.next = null;
        }
        return true;
    }
    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return head.val;
    }
    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return tail.val;
    }
    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return sz == 0;
    }
    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return sz == len;
    }

}