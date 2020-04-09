package com.mohit.greeksofgreeks.linklist;


import com.mohit.leetcode.linklist.ListNode;

public class ThreeSumFromThreeLinkedLists {

    public static void main(String[] args) {
        ThreeSumFromThreeLinkedLists sol = new ThreeSumFromThreeLinkedLists();
        //12->15->10->11->5->6->2->3
        ListNode head = new ListNode(12);
        head.next = new ListNode(6);
        head.next.next = new ListNode(29);

        ListNode two = new ListNode(23);
        two.next = new ListNode(5);
        two.next.next = new ListNode(8);

        ListNode three = new ListNode(90);
        three.next = new ListNode(20);
        three.next.next = new ListNode(59);
        sol.findThreeSumFromThreeLinkedLists(head, two, three, 101);
    }


    public void findThreeSumFromThreeLinkedLists(ListNode one, ListNode two, ListNode three, int target) {
        if (one == null || two == null || three == null) return;


        if (two.next != null) {
            two = insertionSortList(two, true);
        }
        if (three.next != null) {
            three = insertionSortList(three, false);
        }

        while (one != null) {
            ListNode itrTwo = two;
            ListNode itrThree = three;
            while (itrTwo != null && itrThree != null) {
                int sum=one.val + itrTwo.val + itrThree.val;
                if (sum == target) {
                    System.out.println("1. " + one.val + " 2. " + itrTwo.val + " 3. " + itrThree.val);
                    break;
                }
                if (sum > target) {
                    itrThree = itrTwo.next;
                } else {
                    itrTwo = itrTwo.next;
                }
            }
            one = one.next;
        }

    }

    /**
     * Can be use mergeSort here for better time complexity
     */
    public ListNode insertionSortList(ListNode head, boolean isAscendingOrder) {
        if (head == null) {
            return head;
        }

        ListNode node = head;
        ListNode prev = new ListNode(0);
        ListNode listNode = prev;
        ListNode next;
        while (node != null) {
            next = node.next;
            if(isAscendingOrder){
                while (listNode.next != null && (listNode.next.val < node.val)) {
                    listNode = listNode.next;
                }
            }else {
                while (listNode.next != null && (listNode.next.val > node.val)) {
                    listNode = listNode.next;
                }
            }

            node.next = listNode.next;
            listNode.next = node;
            listNode = prev;
            node = next;
        }

        return prev.next;
    }


}
