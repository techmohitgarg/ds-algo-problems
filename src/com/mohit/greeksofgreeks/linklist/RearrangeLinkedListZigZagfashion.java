package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

public class RearrangeLinkedListZigZagfashion {


    public static void main(String[] args) {
        RearrangeLinkedListZigZagfashion sol = new RearrangeLinkedListZigZagfashion();
        //11->15->20->5->10
        ListNode head = new ListNode(11);
        head.next = new ListNode(15);
        head.next.next = new ListNode(20);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        sol.zigZagList(head);
    }

    public void zigZagList(ListNode head) {
        if (head == null) return;

        ListNode curr = head;
        boolean flag = true;
        while (curr != null && curr.next != null) {

            if (flag) {
                if (curr.val > curr.next.val) {
                    int temp = curr.val;
                    curr.val = curr.next.val;
                    curr.next.val = temp;
                }
            } else {
                if (curr.val < curr.next.val) {
                    int temp = curr.val;
                    curr.val = curr.next.val;
                    curr.next.val = temp;
                }
            }
            curr = curr.next;
            flag = !flag;
        }
    }


    /*public void zigZagList(ListNode head) {
        if (head == null) return;
        // First Sort the Elements of the list
        head = sortList(head);

        // Convert the list to zigZag Order
        ListNode curr = head;
        while (curr.next != null && curr.next.next != null) {
            ListNode nextNext = curr.next.next;
            curr.next.next = curr.next.next.next;
            nextNext.next = curr.next;
            curr.next = nextNext;
            curr = curr.next.next;
        }
        PrintLinkList.print(head);
    }*/

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        // get center
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // check if both are empty
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(-1);
        ListNode iter = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        while (l1 != null) {
            node.next = new ListNode(l1.val);
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null) {
            node.next = new ListNode(l2.val);
            l2 = l2.next;
            node = node.next;
        }
        return iter.next;
    }


}

