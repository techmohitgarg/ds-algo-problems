package com.mohit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        new Solution().towerOfHanoi(4, 'A', 'C', 'B');
    }


    public void towerOfHanoi(int n, char from, char to, char ex) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        towerOfHanoi(n - 1, from, ex, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        towerOfHanoi(n - 1, ex, to, from);
    }

}

