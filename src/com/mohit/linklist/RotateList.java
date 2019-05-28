package com.mohit.linklist;

public class RotateList {

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        PrintLinkList.print(rotateList.rotateRight(l1, 2));
    }

//    Input: 1->2->3->4->5->NULL, k = 2
//    Output: 4->5->1->2->3->NULL
//    Explanation:
//    rotate 1 steps to the right: 5->1->2->3->4->NULL
//    rotate 2 steps to the right: 4->5->1->2->3->NULL

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        k = k % (len);
        if (k == 0) return head;
        int step = (len) - k;
        ListNode p = head;
        while (step-- > 1) {
            p = p.next;
        }
        curr.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
}
