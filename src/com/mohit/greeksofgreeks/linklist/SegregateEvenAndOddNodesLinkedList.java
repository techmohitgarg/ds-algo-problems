package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

public class SegregateEvenAndOddNodesLinkedList {

    //[0,9,7,9,9,0]
    public static void main(String[] args) {
        Node listNode = LinkedUtil.makeNode(new int[]{1, 3, 5, 7});
        LinkedUtil.print(segregateEvenOdd(listNode));
    }

    //O(n)
    static Node segregateEvenOdd(Node head) {
        if (head == null) return head;

        Node prevItrEven = null;
        Node prevItrODD = new Node(-1);
        Node itrODD = prevItrODD;

        while (head != null && head.data % 2 != 0) {
            itrODD.next = head;
            itrODD = itrODD.next;
            head = head.next;
        }

        if (head == null) {
            return prevItrODD.next;
        }

        Node itrEven = head;
        while (itrEven != null) {
            if (itrEven.data % 2 != 0) {
                // Set the Odd Value to the odd node
                itrODD.next = itrEven;
                itrODD = itrODD.next;

                // check if PrevItrEven is not null
                if (prevItrEven != null)
                    prevItrEven.next = itrEven.next;

            } else {
                prevItrEven = itrEven;
            }
            itrEven = itrEven.next;
        }

        itrODD.next = null;

        prevItrEven.next = prevItrODD.next;

        return head;
    }
}