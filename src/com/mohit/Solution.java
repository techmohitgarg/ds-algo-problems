package com.mohit;

import com.mohit.leetcode.dynamic_programming.medium.CountingBits;
import com.mohit.leetcode.linklist.ListNode;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(sol.countFriendsPairings(5));
    }

    private int countFriendsPairings(int n) {
        int dp[] = new int[n + 1];

        // Filling dp[] in bottom-up manner using
        // recursive formula explained above.
        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
   /* public ListNode middleNode(ListNode head) {
        // Check if head is null
        if (head == null) return head;

        ListNode itr = head;
        // Find the len of list
        int len = 0;
        while (itr != null) {
            itr = itr.next;
            len++;
        }
        // re-assign the head
        itr = head;

        // Find the middle of the list
        //case even value: 4/2=2
        //case odd value: 3/2=2
        int middle = len / 2;

        // Iteration till middle>0
        while (middle > 0) {
            itr = itr.next;
            middle--;
        }

        return itr;
    }*/

    public ListNode middleNode(ListNode head) {
        /**
         * [1,2,3,4,5]
         *
         * Slow :-{1}-->Step2:-{2}-->Step3:-{3}
         * fast :-{1}-->Step2:-{3}-->Step3:-{5}
         *
         * [1,2,3,4]
         * Slow :-{1}-->Step2:-{2}-->Step3:-{3}
         * fast :-{1}-->Step2:-{3}-->Step3:-{5}
         *
         * In Both case even and odd will get {3->4->5}
         * beacuse we need to return (len/2) value
         */
        //
        if (head == null && head.next == null) return head;
        //Define two node
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            // Move 2 step ahead from current
            fast = fast.next.next;
            // Move 1 step ahead from current
            slow = slow.next;
        }
        //return middle of list
        return slow;
        /**
         * Assume that n=5 n means total number of nodes in the list;
         * Basically we need to find middle of the node from list its nothing but (middle node=n/2)
         * So using 2 pointer 1.fast 2.slow (middle)
         * 1. Fast means i=i+2 ==>Increasing the i by 2
         * we can skip once node every time like (fast=fast.next.next) until (i>n) so iterations will goes up-to n/2 times its nothing but O(n)
         *
         * 2 Slow means middle of the list.
         * Move 1 step by step like (slow=slow.next) until fast not reached at (i>n or fast != null && fast.next != null)
         *
         * Time Complexity : O(n)
         * Space Complexity : O(1)
         */

    }


}

