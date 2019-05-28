package com.mohit.linklist;

import java.util.List;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListII sortedListII = new RemoveDuplicatesfromSortedListII();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);
        PrintLinkList.print(sortedListII.deleteDuplicates(l1));
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && pre.next.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return node.next;
    }

}
