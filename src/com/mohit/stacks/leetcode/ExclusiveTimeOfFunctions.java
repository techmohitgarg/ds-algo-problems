package com.mohit.stacks.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {

    public static void main(String[] args) {
        ExclusiveTimeOfFunctions timeOfFunctions = new ExclusiveTimeOfFunctions();
        String[] log = {"0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"};
        List<String> logs = new ArrayList<>();
        for (int i = 0; i < log.length; i++) {
            logs.add(log[i]);
        }
        int[] num = timeOfFunctions.exclusiveTime(1, logs);
        for (int n : num) {
            System.out.println(String.valueOf(n + " "));
        }
    }


    /*
 ["0:start:0",
 "1:start:2",
 "1:end:5",
 "0:end:6"]
    */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] nums = new int[n];
        Stack<String> stack = new Stack<>();
        int lastProcess = 0;
        int lastFunction = 0;
        for (int i = 0; i < logs.size(); i++) {
            String[] val = logs.get(i).split(":");
            int function_id = Integer.parseInt(val[0]);
            String tag = val[1];
            int time = Integer.parseInt(val[2]);
            if (stack.empty() || (Integer.parseInt(stack.peek().split(":")[0]) != function_id && tag.equals("start"))) {
                if (!stack.empty()) {
                    int process = Math.abs(lastProcess - time);
                    nums[(Integer.parseInt(stack.peek().split(":")[0]))] += process;
                }
                stack.push(logs.get(i));
                lastProcess = time;
                lastFunction = function_id;
            } else if(tag.equals("end")){
                if (stack.empty() == false) {
                    int process = Math.abs(lastProcess - time) + (lastFunction == function_id ? 1 : 0);
                    nums[(Integer.parseInt(stack.peek().split(":")[0]))] += process;
                    stack.pop();
                }
                lastProcess = time;
                lastFunction = function_id;
            }

        }
        return nums;
    }
}
