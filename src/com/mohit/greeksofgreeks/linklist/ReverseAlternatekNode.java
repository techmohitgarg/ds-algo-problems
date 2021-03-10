package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.Node;

import java.util.HashSet;

import static com.mohit.leetcode.linklist.LinkedUtil.makeLoop;
import static com.mohit.leetcode.linklist.LinkedUtil.print;

//Reverse alternate K nodes in a Singly Linked List
public class ReverseAlternatekNode {

    public static void main(String[] args) {
        ReverseAlternatekNode sol = new ReverseAlternatekNode();
        //Node head = LinkedUtil.makeNode(new int[]{1, 8, 3, 4});
        ListNode head = LinkedUtil.makeListNode(new int[]{3, 4, 7, 5, 6, 6, 15, 61, 16});
        ListNode result = sol.solve(head, 3);
        System.out.println(result);
    }

    public ListNode reverseKAlternate(ListNode A, int B) {
        if (A == null) return null;

        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;
        boolean b = true;
        while (current != null) {
            int count = 0;
            while (current != null && count < B) {
                next = current.next;
                if (b)
                    current.next = prev;
                prev = current;
                current = next;
                count++;
            }
            if (b) {


            } else {

            }


            b = !b;


        }
        return prev;
    }

    /*public ListNode reverseKAlternate(ListNode A, int B) {
        ListNode current = A;
        ListNode next = null, prev = null;
        int count = 0;

        while (current != null && count < B) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (A != null) {
            A.next = current;
        }
        count = 0;
        while (count < B - 1 && current != null) {
            current = current.next;
            count++;
        }
        if (current != null) {
            current.next = reverseKAlternate(current.next, B);
        }
        return prev;
    }*/


    void reverse(ListNode temp) {
        ListNode next = null, prev = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }

    public ListNode solve(ListNode A, int B) {
        ListNode temp = A;
        int count = 0;
        ListNode prev = A;
        ListNode prevhead = null;
        while (temp != null) {
            count++;
            if (count == B) {
                A = temp;
            }
            if (count % B == 0) {
                int q = count / B;
                if (q % 2 == 1) {
                    if (prevhead != null)
                        prevhead.next = temp;
                    ListNode next = temp.next;
                    temp.next = null;
                    reverse(prev);
                    prev.next = next;
                    temp = next;
                } else {
                    prevhead = temp;
                    temp = temp.next;
                    prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        return A;
    }

}