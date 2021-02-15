package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

//Reverse alternate K nodes in a Singly Linked List
public class RotateLinkedList {

    public static void main(String[] args) {
        RotateLinkedList sol = new RotateLinkedList();
        Node head = LinkedUtil.makeNode(new int[]{10, 20, 30, 40, 50, 60});
        print(head);
        rotate(head, 6);
    }

    public static Node rotate(Node head, int k) {
        if (head == null) return head;

        int len = 0;
        Node itr = head;
        while (itr != null) {
            ++len;
            itr = itr.next;
        }

        int rotation = k % len;

        if (rotation == 0) {
            return head;
        }

        itr = head;
        Node prev = null;
        while (itr != null && rotation > 0) {
            prev = itr;
            itr = itr.next;
            rotation--;
        }
        prev.next = null;

        Node remain = itr;
        while (remain != null && remain.next != null) {
            remain = remain.next;
        }

        if (remain != null && remain.next == null) {
            remain.next = head;
        }

        return itr;
    }

}