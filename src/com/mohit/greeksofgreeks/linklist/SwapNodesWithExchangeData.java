package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

public class SwapNodesWithExchangeData {

    public static void main(String[] args) {
        SwapNodesWithExchangeData sol = new SwapNodesWithExchangeData();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        sol.swapNodes(head, 3, 5);
    }


    public ListNode swapNodes(ListNode head, int x, int y) {
        if (head == null || x == y) return head;


        ListNode prevX = null;
        ListNode prevY = null;

        ListNode currX = head;

        while (currX != null && currX.val != x) {
            prevX = currX;
            currX = currX.next;
        }
        ListNode currY = head;
        while (currY != null && currY.val != y) {
            prevY = currY;
            currY = currY.next;
        }

        // there is no element to swap
        if (prevX == null && prevY == null) {
            return head;
        }

        // check if x not head
        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        // check if y not head
        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        // Swap next pointers
        ListNode temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }

    public ListNode swapNodes_(ListNode head, int x, int y) {
        if (head == null || x == y) return head;


        ListNode prevX = null;
        ListNode prevY = null;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.val == x) {
                prevX = curr;
            }
            if (curr.next.val == y) {
                prevY = curr;
            }
        }


        if (prevX != null && prevY != null) {
            ListNode temp = prevX.next;
            prevX.next = prevY.next;
            prevY.next = temp;

            temp = prevX.next.next;
            prevX.next.next = prevY.next.next;
            prevY.next.next = temp;
        }

        return head;
    }

}
