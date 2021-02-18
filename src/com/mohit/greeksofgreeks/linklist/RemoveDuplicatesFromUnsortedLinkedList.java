package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

import java.util.HashSet;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class RemoveDuplicatesFromUnsortedLinkedList {


    public static void main(String[] args) {
        Node head = LinkedUtil.makeNode(new int[]{5, 2, 2, 4});
        removeDuplicates(head);
        print(head);

    }

    public static Node removeDuplicates(Node head) {
        if (head == null) return null;
        HashSet<Integer> set = new HashSet<>();
        Node itr = head;
        set.add(itr.data);
        while (itr != null && itr.next != null) {
            if (set.contains(itr.next.data)) {
                itr.next = itr.next.next;
            } else {
                set.add(itr.next.data);
                itr = itr.next;
            }
        }
        return head;
    }
}