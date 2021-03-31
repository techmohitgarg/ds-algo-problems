package com.mohit.leetcode.linklist;


import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import java.util.List;

public class LinkedListSolution {

    public static void main(String[] args) {
        LinkedListSolution solution = new LinkedListSolution();
        ListNode root = LinkedUtil.makeListNode(new int[]{2, 3, 2, 3, 2, 2});
        LinkedUtil.print(solution.partition(root, 1));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode lessThanX = new ListNode(0);
        ListNode itrLess = lessThanX;

        //check if head starting from less value

        while (head != null && head.val < x) {
            ListNode temp = head;
            // set the small value to less node
            itrLess.next = temp;
            itrLess = itrLess.next;
            head = head.next;
        }


        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        while (curr != null) {
            if (curr.val < x) {
                temp = curr;
                //Delete the small value from the head
                prev.next = curr.next;
                // set the small value to less node
                itrLess.next = temp;
                itrLess = itrLess.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        itrLess.next = head;

        return lessThanX.next;
    }

}