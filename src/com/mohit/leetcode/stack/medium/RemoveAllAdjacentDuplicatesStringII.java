package com.mohit.leetcode.stack.medium;


public class RemoveAllAdjacentDuplicatesStringII {
    public class Pair<A, B> {

        public final A fst;
        public final B snd;

        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesStringII sol = new RemoveAllAdjacentDuplicatesStringII();
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa", 3));
    }

    public String removeDuplicates(String s, int k) {
        char[] sb = new char[s.length()];
        int[] dq = new int[s.length()];
        int sz = 0;
        for (char ch : s.toCharArray()) {
            dq[sz] = sz > 0 && sb[sz - 1] == ch ? dq[sz - 1] + 1 : 1;
            sb[sz++] = ch;
            if (dq[sz - 1] == k) sz -= k;
        }
        return new String(sb, 0, sz);
    }

    /*public String removeDuplicates(String s, int k) {
        if (s.length() == 0 || k == 0) return s;
        int i = 0;
        Stack<Pair<Character, Integer>> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().fst == ch && stack.peek().snd == k - 1) {
                while (!stack.isEmpty() && stack.peek().fst == ch) {
                    stack.pop();
                }
                result.delete(result.length() - k + 1, result.length());
            } else {
                if (!stack.isEmpty() && stack.peek().fst == s.charAt(i)) {
                    stack.push(new Pair<>(ch, stack.peek().snd + 1));
                } else {
                    stack.push(new Pair<>(ch, 1));
                }
                result.append(ch);
            }
            i++;
        }
        return result.toString();
    }*/

}