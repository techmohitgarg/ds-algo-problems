package com.mohit.leetcode.stack.medium;

public class ScoreofParentheses {
    public static void main(String[] args) {
        System.out.println(new ScoreofParentheses().scoreOfParentheses("(()(()))"));
    }

    /*
    Example 1:
    Input: "()"
    Output: 1

    Example 2:
    Input: "(())"
    Output: 2

    Example 3:
    Input: "()()"
    Output: 2

    Example 4:
    Input: "(()(()))"
    Output: 6
    */

    public int scoreOfParentheses(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(')
                    ans += 1 << bal;
            }
        }

        return ans;
    }

    /*public int scoreOfParentheses(String S) {
        Stack<Integer> ans = new Stack<>();
        ans.push(0);
        for (int k = 0; k < S.length(); k++) {
            if (S.charAt(k) == '(') {
                ans.push(0);
            } else {
                int v = ans.pop();
                int w = ans.pop();
                ans.push(w + Math.max(2 * v, 1));
            }

        }
        return ans.pop();
    }*/

    /*public int scoreOfParentheses(String S) {
        return scoreOfParatheses(S, 0, S.length());
    }*/


    public int scoreOfParatheses(String s, int i, int j) {
        int ans = 0;
        int res = 0;
        for (int k = i; k < j; k++) {
            if (s.charAt(k) == '(') res++;
            else res--;

            if (res == 0) {
                if (k - i == 1) {
                    ans++;
                } else {
                    ans += 2 * scoreOfParatheses(s, i + 1, k);
                }
                i = k + 1;
            }
        }
        return ans;
    }

}