package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class PartitionList {

    public static void main(String[] args) {
        PartitionList list = new PartitionList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(2);
        print(list.partition(l1, 3));
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

    /*public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode node = new ListNode(0);
        ListNode before = node;
        ListNode node_ = new ListNode(0);
        ListNode after = node_;
        ListNode iter = head;
        while (iter != null) {
            if (iter.val < x) {
                before.next = new ListNode(iter.val);
                before = before.next;
            } else {
                after.next = new ListNode(iter.val);
                after = after.next;
            }
            iter = iter.next;
        }

        before.next = node_.next;
        return node.next;
    }*/

}
