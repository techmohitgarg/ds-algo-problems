package com.mohit.leetcode.linklist.easy;

import com.mohit.leetcode.linklist.ListNode;

public class MiddleoftheLinkedList {

    public static void main(String[] args) {
        MiddleoftheLinkedList list = new MiddleoftheLinkedList();
        list.middleNode(null);

    }

     /*public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        node = head;
        int i = 0;
        size = (size % 2 == 0) ? (size / 2) + 1 : (size / 2);
        while (i < size) {
            node = node.next;
            i++;
        }
        return node;
    }*/

    public ListNode middleNode(ListNode head) {
        /**
         * [1,2,3,4,5]
         *
         * Slow :-{1}-->Step2:-{2}-->Step3:-{3}
         * fast :-{1}-->Step2:-{3}-->Step3:-{5}
         *
         * [1,2,3,4]
         * Slow :-{1}-->Step2:-{2}-->Step3:-{3}
         * fast :-{1}-->Step2:-{3}-->Step3:-{5}
         *
         * In Both case even and odd will get {3->4->5}
         * beacuse we need to return (len/2) value
         */
        //
        if (head == null && head.next == null) return head;
        //Define two node
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            // Move 2 step ahead from current
            fast = fast.next.next;
            // Move 1 step ahead from current
            slow = slow.next;
        }
        //return middle of list
        return slow;
        /**
         * Assume that n=5 n means total number of nodes in the list;
         * Basically we need to find middle of the node from list its nothing but (middle node=n/2)
         * So using 2 pointer 1.fast 2.slow (middle)
         * 1. Fast means i=i+2 ==>Increasing the i by 2
         * we can skip once node every time like (fast=fast.next.next) until (i>n) so iterations will goes up-to n/2 times its nothing but O(n)
         *
         * 2 Slow means middle of the list.
         * Move 1 step by step like (slow=slow.next) until fast not reached at (i>n or fast != null && fast.next != null)
         *
         * Time Complexity : O(n)
         * Space Complexity : O(1)
         */

    }

}
