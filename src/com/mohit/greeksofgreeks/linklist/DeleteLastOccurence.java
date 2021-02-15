package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

public class DeleteLastOccurence {

    public static void main(String[] args) {
        DeleteLastOccurence sol = new DeleteLastOccurence();
        Node head = LinkedUtil.makeNode(new int[]{1, 2, 3, 5, 2, 10});
        sol.deleteLastOccurrence(head, 2);
    }


    public void deleteLastOccurrence(Node head, int value) {
        if (head == null) return;

        Node itr = head;
        Node prev = null;
        Node last = null;
        Node lastOPrev = null;
        while (itr != null) {
            if (itr.data == value) {
                lastOPrev = prev;
                last = itr;
            }
            prev = itr;
            itr = itr.next;
        }

        if (lastOPrev != null)
            lastOPrev.next = last.next;
    }
}