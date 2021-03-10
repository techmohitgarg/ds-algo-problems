package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.Node;

public class SwapNodesWithExchangeData {

    public static void main(String[] args) {
        SwapNodesWithExchangeData sol = new SwapNodesWithExchangeData();
        Node head = LinkedUtil.makeNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        sol.swapNodes(head, 3, 5);
    }
    //Swap nodes in a linked list without swapping data

    private static void swapNodes(Node head, int x, int y) {
        if (head == null || head.next == null) return;


        if (x == y) return;

        Node itrX = head;
        Node itrY = head;
        Node prev_x = null;
        Node prev_y = null;
        // Searching for x and prev-x
        while (itrX != null && itrX.data != x) {
            prev_x = itrX;
            itrX = itrX.next;
        }
        // Searching for y and prev-y
        while (itrY != null && itrY.data != y) {
            prev_y = itrY;
            itrY = itrY.next;
        }

        // check if current index is null
        if (itrX == null || itrY == null) return;

        if (prev_x != null) {
            prev_x.next = itrY;
        } else {
            head = itrY;
        }

        if (prev_y != null) {
            prev_y.next = itrX;
        } else {
            head = itrX;
        }

        Node temp = itrX.next;
        itrX.next = itrY.next;
        itrY.next = temp;

    }

}
