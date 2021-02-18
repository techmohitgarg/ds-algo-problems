package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

import static com.mohit.leetcode.linklist.LinkedUtil.makeLoop;

public class FindLengthOfLoop {


    public static void main(String[] args) {
        Node head = LinkedUtil.makeNode(new int[]{10, 12, 14, 15, 19, 20});
        makeLoop(head, 3);
        int count = countNodesinLoop(head);
        System.out.println(count);
    }


    static int countNodesinLoop(Node head) {
        Node slow = head, fast = head;
        while (slow != null && fast != null
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                Node ptr1 = slow;
                Node ptr2 = slow;
                int count = 1;
                while (ptr1.next != ptr2) {
                    ptr1 = ptr1.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
}