package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

import java.util.Stack;

public class AlternateOddAndEvenNodes {

    public static void main(String[] args) {
        AlternateOddAndEvenNodes sol = new AlternateOddAndEvenNodes();
        //11 -> 20 -> 40 -> 55 -> 77 -> 80 -> NULL
        //11 -> 20 -> 55 -> 40 -> 77 -> 80 -> NULL
        ListNode head = new ListNode(11);
        head.next = new ListNode(20);
        head.next.next = new ListNode(40);
        head.next.next.next = new ListNode(55);
        head.next.next.next.next = new ListNode(77);
        head.next.next.next.next.next = new ListNode(80);
        sol.rearrangeOddEven(head);
    }

    void rearrangeOddEven(ListNode head) {
        Stack<ListNode> odd = new Stack<>();
        Stack<ListNode> even = new Stack<>();
        int i = 1;

        ListNode itr = head;
        while (itr != null) {

            if (itr.val % 2 != 0 && i % 2 == 0) {

                // Odd Value in Even Position
                // Add pointer to current node
                // in odd stack
                odd.push(itr);
            } else if (itr.val % 2 == 0 && i % 2 != 0) {

                // Even Value in Odd Position
                // Add pointer to current node
                // in even stack
                even.push(itr);
            }

            itr = itr.next;
            i++;
        }

        while (odd.size() > 0 && even.size() > 0) {

            // Swap Data at the top of two stacks
            int k = odd.peek().val;
            odd.peek().val = even.peek().val;
            even.peek().val = k;
            odd.pop();
            even.pop();
        }
    }

}
