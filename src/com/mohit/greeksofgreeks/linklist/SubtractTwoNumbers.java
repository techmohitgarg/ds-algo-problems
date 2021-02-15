package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class SubtractTwoNumbers {
    public static void main(String[] args) {
        SubtractTwoNumbers sol = new SubtractTwoNumbers();
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(6);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(6);
        print(sol.subtractTwoList(l1, l2));
    }


    public ListNode subtractTwoList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }

        int lenA = 1;
        ListNode currA = l1;
        while (currA.next != null) {
            currA = currA.next;
            lenA++;
        }

        int lenB = 1;
        ListNode currB = l2;
        while (currB.next != null) {
            currB = currB.next;
            lenB++;
        }
        // Adding the Zero at front in the Short list
        ListNode lNode = null;
        ListNode sNode = null;
        if (lenA != lenB) {
            if (lenA < lenB) {
                while (lenA < lenB) {
                    ListNode node = new ListNode(0);
                    node.next = l1;
                    l1 = node;
                    lenA++;
                }
                lNode = l2;
                sNode = l1;
            } else {
                while (lenB < lenA) {
                    ListNode node = new ListNode(0);
                    node.next = l2;
                    l2 = node;
                    lenB++;
                }
                lNode = l1;
                sNode = l2;
            }
        } else {

            currA = l1;
            currB = l2;
            while (currA != null && currB != null) {
                if (currA.val != currB.val) {
                    lNode = currA.val > currB.val ? l1 : l2;
                    sNode = currA.val > currB.val ? l2 : l1;
                    break;
                }
                currA = currA.next;
                currB = currB.next;
            }

        }
        boolean b = subtractTwoListHelper(lNode, sNode);

        while (lNode != null && lNode.val == 0) {
            lNode = lNode.next;
        }
        return lNode;
    }


    public boolean subtractTwoListHelper(ListNode lNode, ListNode sNode) {
        if (lNode == null && sNode == null) {
            return false;
        }
        boolean borrow = subtractTwoListHelper(lNode.next, sNode.next);

        int d1 = lNode.val;
        int d2 = sNode.val;
        if (borrow) {
            d1 = d1 - 1;
            borrow = false;
        }

        if (d1 < d2) {
            d1 = 10 + d1;
            borrow = true;
        }

        int sub = d1 - d2;
        lNode.val = sub;
        return borrow;
    }

}

