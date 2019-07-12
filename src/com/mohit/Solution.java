package com.mohit;

import com.mohit.linklist.ListNode;
import com.mohit.linklist.PrintLinkList;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        PrintLinkList.print(main.mergeKLists(new ListNode[0]));
    }

    public ListNode mergeKLists(ListNode[] lists) {

    }


}
