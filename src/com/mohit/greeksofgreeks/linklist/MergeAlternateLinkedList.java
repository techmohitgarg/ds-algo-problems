package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

public class MergeAlternateLinkedList {

    public static void main(String[] args) {
        MergeAlternateLinkedList sol = new MergeAlternateLinkedList();

        Node list1 = LinkedUtil.makeNode(new int[]{9, 11});
        Node list2 = LinkedUtil.makeNode(new int[]{5, 4, 3, 2, 1, 6});
        sol.mergeAlternate(list1, list2);

    }

    private void mergeAlternate(Node list1, Node list2) {
        if (list1 == null && list2 == null) {
            return;
        }

        Node itr1 = list1;
        Node next;
        while (itr1 != null && list2 != null) {
            next = itr1.next;
            itr1.next = list2;
            list2 = list2.next;
            itr1.next.next = next;
            itr1 = next;
        }

        while (list1 != null) {
            System.out.print(list1.data + " ");
            list1 = list1.next;
        }
        System.out.println();
        while (list2 != null) {
            System.out.print(list2.data + " ");
            list2 = list2.next;
        }
    }


}