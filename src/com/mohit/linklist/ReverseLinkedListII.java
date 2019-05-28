package com.mohit.linklist;


import java.util.List;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ReverseLinkedListII listII = new ReverseLinkedListII();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        PrintLinkList.print(listII.reverseBetween(l1, 1, 6));

    }

    /*Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL*/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n || m > n) {
            return head;
        }

        ListNode reverseNode = new ListNode(0);
        ListNode tempReverse = reverseNode;
        ListNode node = head;
        int i = 1;
        while (node != null && i < m) {
            tempReverse.next = new ListNode(node.val);
            tempReverse = tempReverse.next;
            node = node.next;
            i++;
        }

        ListNode prev = null;
        ListNode next = null;
        while (node != null && i <= n) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            i++;
        }


        // Add Remain List in Prev list
        ListNode rev = prev;
        while (rev.next != null) {
            rev = rev.next;
        }
        if (rev.next == null) {
            rev.next = next;
        }

        // Add the reverse List
        tempReverse.next = prev;


        return reverseNode.next;
    }
}
