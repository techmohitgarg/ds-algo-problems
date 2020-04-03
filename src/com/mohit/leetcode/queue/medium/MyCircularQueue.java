package com.mohit.leetcode.queue.medium;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.strings.medium.NumDecodings;

import java.util.ArrayList;
import java.util.List;

public class MyCircularQueue {
    /**
     * enQueue :O(1)
     * deQueue :O(1) Because we have to remove zero index like (head=head.next)
     * Front   :O(1)
     * Rear    :O(1)
     * isEmpty :O(1)
     * isFull  :O(1)
     * <p>
     * MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
     * System.out.println(circularQueue.enQueue(1));  // return true
     * System.out.println(circularQueue.enQueue(2));  // return true
     * System.out.println(circularQueue.enQueue(3));  // return true
     * System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
     * System.out.println(circularQueue.Rear());  // return 3
     * System.out.println(circularQueue.isFull());  // return true
     * System.out.println(circularQueue.deQueue());  // return true
     * System.out.println(circularQueue.enQueue(4));  // return true
     * System.out.println(circularQueue.Rear());  // return 4
     */
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
    public MyCircularQueue(int k) {
        len = k;
    }
    public boolean enQueue(int value) {
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
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = head.next;
        sz--;
        if (sz == 0) {
            tail = null;
        }
        return true;
    }
    public int Front() {
        if (isEmpty()) return -1;
        return head.val;
    }
    public int Rear() {
        if (isEmpty()) return -1;
        return tail.val;
    }
    public boolean isEmpty() {
        return sz == 0;
    }
    public boolean isFull() {
        return sz == len;
    }
}