package com.mohit.leetcode.linklist.easy;

import com.mohit.leetcode.linklist.ListNode;

public class ConvertBinaryNumberToDecimal {

    public static void main(String[] args) {
        ConvertBinaryNumberToDecimal sol = new ConvertBinaryNumberToDecimal();
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        System.out.println(sol.getDecimalValue(node));
    }

    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        StringBuilder binary = new StringBuilder();

        ListNode itr = head;
        while (itr != null) {
            binary.append(itr.val);
            itr = itr.next;
        }
        int ans = Integer.parseInt(binary.toString(), 2);
        return ans;
    }

}