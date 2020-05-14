package com.mohit.leetcode.stack;


import java.util.*;

public class PoisonousPlantProblem {


    public static void main(String[] args) {
        PoisonousPlantProblem sol = new PoisonousPlantProblem();
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = {1, 3, 1, 2, 0, 5};
        sol.poisonousPlants(arr);
    }

    public int poisonousPlants(int[] p) {
        if (p.length == 0) return 0;
        int days = 0;

        Stack<LinkedList<Integer>> stack = new Stack<>();
        stack.push(new LinkedList());
        for (int i = 0; i < p.length; i++) {
            if (stack.peek().isEmpty() || (stack.peek().getLast() >= p[i])) {
                stack.peek().add(p[i]);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(p[i]);
                stack.push(list);
            }
        }

        while (stack.size() > 1) {
            Stack<LinkedList<Integer>> temp = new Stack<>();
            while (stack.size() > 1) {
                LinkedList<Integer> list = stack.pop();
                list.removeFirst();
                if (list.size() > 0) {
                    temp.push(list);
                }
            }
            while (!temp.isEmpty()) {
                if (stack.peek().getLast() >= temp.peek().getFirst()) {
                    stack.peek().addAll(temp.pop());
                } else {
                    stack.push(temp.pop());
                }
            }
            days++;
        }

        return days;
    }


}