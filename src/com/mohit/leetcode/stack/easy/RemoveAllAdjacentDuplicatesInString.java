package com.mohit.leetcode.stack.easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates("abbaca"));
    }

    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
            i++;
        }
        StringBuilder builder=new StringBuilder();
        for (char c:stack){
            builder.append(c);
        }
        return builder.toString();
    }
}
