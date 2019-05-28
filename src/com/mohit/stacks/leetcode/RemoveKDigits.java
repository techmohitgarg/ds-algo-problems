package com.mohit.stacks.leetcode;

import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        RemoveKDigits digits = new RemoveKDigits();
        System.out.println(digits.removeKdigits("1432219", 3));

    }
    /*Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.*/

    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || k == 0) {
            return num;
        }
        if (num.length() == 1 && k == 1) {
            return "0";
        }
        Stack<Character> smallNum = new Stack<>();
        char[] ch = num.toCharArray();
        int i = 0;
        while (i < ch.length) {
            while (k > 0 && !smallNum.empty() && smallNum.peek() > ch[i]) {
                smallNum.pop();
                k--;
            }
            smallNum.push(ch[i]);
            i++;
        }
        while (k > 0) {
            smallNum.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!smallNum.isEmpty()) {
            sb.append(smallNum.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
