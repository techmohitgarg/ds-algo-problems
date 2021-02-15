package com.mohit.greeksofgreeks.linklist;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.Node;

import java.util.HashSet;

import static com.mohit.leetcode.linklist.LinkedUtil.makeLoop;
import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class RemoveLoopLinkedList {

    public static void main(String[] args) {
        RemoveLoopLinkedList sol = new RemoveLoopLinkedList();
        Node head = LinkedUtil.makeNode(new int[]{1, 8, 3, 4});
        print(head);
        makeLoop(head, 1);
        sol.detectAndRemoveLoop(head);
    }

    int detectAndRemoveLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop Without using the memory
    void removeLoop(Node loop, Node head) {
        Node ptr1 = loop;
        Node ptr2 = loop;
        int k = 1, i;
        while (ptr1.next != ptr2) {
            ptr1 = ptr1.next;
            k++;
        }
        ptr1 = head;
        ptr2 = head;
        for (i = 0; i < k; i++) {
            ptr2 = ptr2.next;
        }
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while (ptr2.next != ptr1) {
            ptr2 = ptr2.next;
        }

        /* Set the next node of the loop ending node
         to fix the loop */
        ptr2.next = null;
    }

    //Remove loop in Linked List Using HashMap
    public static void removeLoop(Node head) {
        if (head == null) return;

        HashSet<Node> map = new HashSet<>();
        Node itr = head;
        Node loopNode = null;
        while (itr != null) {
            if (map.contains(itr)) {
                loopNode = itr;
                break;
            } else {
                map.add(itr);
            }

            itr = itr.next;
        }


        if (loopNode == null) return;

        itr = loopNode;
        while (itr.next != null && itr.next != loopNode) {
            itr = itr.next;
        }
        itr.next = null;
    }
}