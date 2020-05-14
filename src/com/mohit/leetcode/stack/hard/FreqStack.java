package com.mohit.leetcode.stack.hard;

import com.mohit.Solution;

import java.util.HashMap;
import java.util.Stack;

class FreqStack {
    Stack<Integer> stack;
    Stack<Integer> mostFreq;
    HashMap<Integer, Integer> map;

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        String[] val = {"FreqStack", "push", "push", "push", "push", "push", "push", "pop", "push", "pop", "push", "pop", "push", "pop", "push", "pop", "pop", "pop", "pop", "pop", "pop"};
        String dummy = "[[],[718967141],[189971378],[341560426],[23521218],[339517772],[967482459],[],[978798455],[],[744530040],[],[3454610],[],[940238504],[],[],[],[],[],[]]";
        dummy = dummy.replace("[", "").replace("]", "");
        String[] data = dummy.split(",");
        for (int i = 1; i < val.length; i++) {
            if (data[i].length() == 0) {
                System.out.println(stack.pop());
            } else {
                stack.push(Integer.parseInt(data[i]));
            }
        }

    }

    public FreqStack() {
        stack = new Stack<>();
        mostFreq = new Stack<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        // Push the element in the stack
        stack.push(x);
        map.put(x, map.getOrDefault(x, 0) + 1);

        if (mostFreq.isEmpty()) {
            mostFreq.push(x);
        } else {
            if (map.get(mostFreq.peek()) > map.get(x)) {
                mostFreq.push(mostFreq.peek());
            } else {
                mostFreq.push(x);
            }
        }

    }

    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty() &&
                stack.peek() != mostFreq.peek() &&
                map.get(mostFreq.peek()) != map.get(stack.peek())) {
            temp.push(stack.peek());
            map.put(stack.peek(), map.getOrDefault(stack.peek(), 0) - 1);
            stack.pop();
            mostFreq.pop();
        }

        // Remove the top value if equal to maxValue
        int most = stack.peek();
        map.put(most, map.getOrDefault(most, 0) - 1);
        stack.pop();
        mostFreq.pop();

        // Add temp value in the original stack
        while (!temp.isEmpty()) push(temp.pop());

        return most;
    }

    /*class FreqStack {
        HashMap<Integer, Integer> elements;
        HashMap<Integer, Stack<Integer>> frequencyMap;
        int maxFrequencyElement = 0;

        public FreqStack() {
            elements = new HashMap<>();
            frequencyMap = new HashMap<>();
        }

        public void push(int x) {
            int frequency = elements.getOrDefault(x, 0) + 1;
            elements.put(x, frequency);

            if (!frequencyMap.containsKey(frequency)) {
                frequencyMap.put(frequency, new Stack<>());
            }
            frequencyMap.get(frequency).push(x);
            maxFrequencyElement = Math.max(maxFrequencyElement, frequency);
        }

        public int pop() {
            int value = frequencyMap.get(maxFrequencyElement).pop();
            elements.put(value, elements.getOrDefault(value, 0) - 1);
            if (frequencyMap.get(maxFrequencyElement).isEmpty()) {
                maxFrequencyElement--;
            }
            return value;
        }
    }*/

}