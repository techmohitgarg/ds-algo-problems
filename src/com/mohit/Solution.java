package com.mohit;

import com.mohit.leetcode.linklist.ListNode;
import com.mohit.leetcode.queue.medium.MyCircularDequeUsingDoublyLinkedList;
import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;
import com.sun.tools.javac.util.Pair;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Scanner s = new Scanner(System.in);
        sol.areSame("-(a+b+c)", "-a-b-c");
    }

    public boolean areSame(String expr1, String expr2) {
        int[] val = new int[26];

        eval(expr1, val, true);
        eval(expr2, val, false);

        for (int i = 0; i < val.length; i++) {
            if (val[i] != 0) return false;
        }
        return true;
    }


    public void eval(String exp, int[] val, boolean add) {
        if (exp.length() == 0) return;

        Stack<Boolean> op = new Stack<>();
        op.push(true);
        int i = 0;
        while (i < exp.length()) {
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                i++;
                continue;
            } else if (exp.charAt(i) == '(') {
                // Add Sign here
                if (addSign(exp, i)) {
                    op.add(op.peek());
                } else {
                    op.add(!op.peek());
                }
            } else if (exp.charAt(i) == ')') {
                if (!op.isEmpty())
                    op.pop();
            } else {
                // If the Sign is positive means we have to add the number
                if (op.peek()) {
                    val[exp.charAt(i) - 'a'] += addSign(exp, i) ? add ? 1 : -1 : add ? -1 : 1;
                } else {
                    val[exp.charAt(i) - 'a'] += addSign(exp, i) ? add ? -1 : 1 : add ? 1 : -1;
                }
            }

            i++;
        }


    }


    private boolean addSign(String str, int i) {
        if (i == 0) return true;
        else if (str.charAt(i - 1) == '-') return false;
        else return true;
    }

}