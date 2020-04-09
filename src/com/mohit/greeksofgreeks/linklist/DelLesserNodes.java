package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.linklist.PrintLinkList;

public class DelLesserNodes {

    public static void main(String[] args) {
        DelLesserNodes sol = new DelLesserNodes();
        //12->15->10->11->5->6->2->3
        ListNode head = new ListNode(12);
        head.next = new ListNode(15);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(3);
        sol.delLesserNodes(head);
    }


    public void delLesserNodes(ListNode head) {
        if (head == null || head.next == null) return;


        ListNode curr = new ListNode(-1);
        curr.next = head;
        ListNode itr = curr;

        while (itr != null && itr.next != null && itr.next.next != null) {
            if (itr.next.val < itr.next.next.val) {
                itr.next = itr.next.next;
            } else {
                itr = itr.next;
            }
        }
        PrintLinkList.print(curr.next);
    }


}
