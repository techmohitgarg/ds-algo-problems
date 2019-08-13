package com.mohit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] str = new String[]{"0:start:0", "0:end:100000000"};
        List<String> logs = new ArrayList<>();
        for (String log : str) {
            logs.add(log);
        }
        new Solution().exclusiveTime(1, logs);
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs.size() == 0) return new int[]{};
        int[] data = new int[n];
        Stack<Integer> stack = new Stack<>();

        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int time = Integer.parseInt(s[2]);
        int i = 1;
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            int t = Integer.parseInt(s[2]);
            if (time < t) {
                int diff = t - time;
                data[stack.peek()] += diff;
                time += diff;

            }
            if (s[1].equals("start")) {
                stack.push(Integer.parseInt(s[0]));
            } else {
                data[stack.peek()]++;
                time++;
                stack.pop();
            }
            i++;

        }
        return data;
    }


}