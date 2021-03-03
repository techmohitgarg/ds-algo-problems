package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class MoveLastElementToFront {


    public static void main(String[] args) {
        Node listNodeHead = LinkedUtil.makeNode(new int[]{1, 2, 3, 4, 5});
        print(moveLastToFirst_(listNodeHead));
    }

    //Move last element to front of a given Linked List
    //using data change
    private static Node moveLastToFirst(Node head) {
        if (head == null || head.next == null) return head;

        Node itr = head;
        int next = itr.data;
        while (itr != null && itr.next != null) {
            int temp = itr.next.data;
            itr.next.data = next;
            next = temp;
            itr = itr.next;
        }

        head.data = next;
        return head;
    }

    // Without changing the node data
    private static Node moveLastToFirst_(Node head) {
        if (head == null || head.next == null) return head;

        Node itr = head;
        Node prev = null;
        while (itr != null && itr.next != null) {
            prev = itr;
            itr = itr.next;
        }
        itr.next = head;
        prev.next = null;
        head = itr;
        return head;
    }
}