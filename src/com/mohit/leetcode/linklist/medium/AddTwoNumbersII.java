package com.mohit.leetcode.linklist.medium;

import com.mohit.leetcode.linklist.LinkedUtil;
import com.mohit.leetcode.linklist.ListNode;

import java.util.List;
import java.util.Stack;

import static com.mohit.leetcode.linklist.LinkedUtil.print;

public class AddTwoNumbersII {
    public static void main(String[] args) {
        AddTwoNumbersII numbersII = new AddTwoNumbersII();
        ListNode l1 = LinkedUtil.makeListNode(new int[]{5});
        ListNode l2 = LinkedUtil.makeListNode(new int[]{5});

        print(numbersII.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int n1 = 0;
        ListNode itr1 = l1;
        while (itr1 != null) {
            itr1 = itr1.next;
            n1++;
        }

        int n2 = 0;
        ListNode itr2 = l2;
        while (itr2 != null) {
            itr2 = itr2.next;
            n2++;
        }

        ListNode result = addNumber(l1, l2, n1, n2);
        if (carry == 1) {
            ListNode node = new ListNode(carry);
            node.next = result;
            return node;
        }
        return result;
    }

    int carry = 0;

    private ListNode addNumber(ListNode l1, ListNode l2, int n1, int n2) {
        ListNode prev1;
        ListNode prev2;

        if (n1 == 0 && n2 == 0) {
            return null;
        } else if (n1 > n2) {
            prev1 = l1;
            ListNode result = addNumber(l1.next, l2, n1 - 1, n2);
            if (prev1 != null) {
                carry += prev1.val;
            }
            ListNode temp = new ListNode(carry % 10);
            temp.next = result;
            carry /= 10;
            return temp;
        } else if (n2 > n1) {
            prev2 = l2;
            ListNode result = addNumber(l1, l2.next, n1, n2 - 1);
            if (prev2 != null) {
                carry += prev2.val;
            }
            ListNode temp = new ListNode(carry % 10);
            temp.next = result;
            carry /= 10;
            return temp;

        } else {
            prev1 = l1;
            prev2 = l2;
            ListNode result = addNumber(l1.next, l2.next, n1 - 1, n2 - 1);
            if (prev1 != null) {
                carry += prev1.val;
            }
            if (prev2 != null) {
                carry += prev2.val;
            }
            ListNode temp = new ListNode(carry % 10);
            temp.next = result;
            carry /= 10;
            return temp;
        }
    }

    public ListNode addTwoNumbers_(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }
        }
        ListNode node = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            if (!s1.isEmpty()) {
                carry += s1.pop();
            }
            if (!s2.isEmpty()) {
                carry += s2.pop();
            }
            ListNode temp = new ListNode(carry % 10);
            temp.next = node;
            node = temp;
            carry /= 10;
        }

        return node;
    }
}
