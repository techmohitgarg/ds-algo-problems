package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

import java.util.HashSet;

import static com.mohit.leetcode.linklist.LinkedUtil.makeLoop;
import static com.mohit.leetcode.linklist.LinkedUtil.print;

//Reverse alternate K nodes in a Singly Linked List
public class ReverseAlternatekNode {

    public static void main(String[] args) {
        ReverseAlternatekNode sol = new ReverseAlternatekNode();
        Node head = LinkedUtil.makeNode(new int[]{1, 8, 3, 4});
        sol.reverseKAlternate(head, 2);
    }


    public Node reverseKAlternate(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node next = null;
        Node curr = head;
        Node prev = null;
        //using first node here because after the reverse the
        //k node we have to append the remain list with first node.
        Node first = head;
        for (int i = 0; i < k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //append the remain list into the list
        first.next = next;

        return prev;
    }


}