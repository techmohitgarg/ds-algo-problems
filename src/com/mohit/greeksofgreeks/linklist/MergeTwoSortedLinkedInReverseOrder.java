package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

public class MergeTwoSortedLinkedInReverseOrder {

    public static void main(String[] args) {
        MergeTwoSortedLinkedInReverseOrder sol = new MergeTwoSortedLinkedInReverseOrder();
        //17->15->8->12->10->5->4->1->7->6
        ListNode head = new ListNode(5);
        head.next = new ListNode(10);
        head.next.next = new ListNode(15);
        head.next.next.next = new ListNode(40);

        ListNode headB = new ListNode(2);
        headB.next = new ListNode(3);
        headB.next.next = new ListNode(20);

        sol.mergeListFromRightToLeft(head, headB);
    }


    public ListNode mergeListFromRightToLeft(ListNode headA, ListNode headB) {

        if (headA == null && headB == null) return null;
        else if (headA == null) return headB;
        else if (headB == null) return headA;



        ListNode itr = null;
        while (headA != null && headB != null) {
            if (headA.val <= headB.val) {
                ListNode newest = new ListNode(headA.val);
                if (itr != null) {
                    newest.next = itr;
                }
                itr = newest;
                headA = headA.next;
            } else {
                ListNode newest = new ListNode(headB.val);
                if (itr != null) {
                    newest.next = itr;
                }
                itr = newest;
                headB = headB.next;
            }
        }

        if (headA != null) {
            while (headA != null) {
                ListNode newest = new ListNode(headA.val);
                if (itr != null) {
                    newest.next = itr;
                }
                itr = newest;
                headA = headA.next;
            }
        }
        if (headB != null) {
            while (headB != null) {
                ListNode newest = new ListNode(headB.val);
                if (itr != null) {
                    newest.next = itr;
                }
                itr = newest;
                headB = headB.next;
            }
        }
        return itr;

    }


}
