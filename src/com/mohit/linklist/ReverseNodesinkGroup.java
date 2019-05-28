package com.mohit.linklist;

public class ReverseNodesinkGroup {

    public static void main(String[] args) {
        ReverseNodesinkGroup group = new ReverseNodesinkGroup();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        PrintLinkList.print(group.reverseKGroup(l1, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        // get size
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        cur = head;
        ListNode prev = null;
        ListNode next = null;
        ListNode group = new ListNode(0);
        ListNode listNode = group;
        int i = 0;
        while (i < (count / k)) {
            int j = k;
            while (cur != null && j > 0) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                if (listNode != null) {
                    listNode = listNode.next;
                }

                j--;
            }
            listNode.next = prev;
            prev = null;
            i++;
        }
        if (count % k != 0) {
            listNode.next = cur;

        }
        return group.next;
    }
}
