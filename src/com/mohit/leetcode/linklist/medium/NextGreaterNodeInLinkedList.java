package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.ListNode;

import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList main = new NextGreaterNodeInLinkedList();
        ListNode one = new ListNode(2);
        one.next = new ListNode(1);
        one.next.next = new ListNode(5);


        main.nextLargerNodes(one);
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        ListNode itr = head;
        int len = 0;
        while (itr != null) {
            itr = itr.next;
            len++;
        }
        itr = head;
        int[] num = new int[len];
        Stack<int[]> s = new Stack<>();
        int i = 0;
        while (itr != null) {
            while (!s.isEmpty() && itr.val > s.peek()[1]) {
                num[s.peek()[0]] = itr.val;
                s.pop();
            }
            s.push(new int[]{i++, itr.val});
            itr = itr.next;
        }
        return num;
    }

    public int[] nextLargerNodes_(ListNode head) {
        if (head == null) return new int[]{};

        if (head.next == null) return new int[]{0};

        int[] nums = new int[10000];

        int index = 0, len = 0;

        ListNode itr = head;

        Stack<int[]> values = new Stack<>();

        while (itr != null) {
            while (!values.isEmpty() && values.peek()[1] < itr.val) {
                int[] data = values.pop();
                nums[data[0]] = itr.val;
            }
            values.add(new int[]{index, itr.val});
            index++;
            len++;
            itr = itr.next;
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = nums[i];
        }
        return result;
    }

}
