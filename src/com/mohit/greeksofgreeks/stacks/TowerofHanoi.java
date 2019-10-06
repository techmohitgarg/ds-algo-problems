package com.mohit.greeksofgreeks.stacks;

import java.util.Stack;

public class TowerofHanoi {

    public static void main(String[] args) {
        //new Solution().towerOfHanoi(4, 'A', 'C', 'B');
        int n = 3;
        new TowerofHanoi().towerOfHanoiWithOutRescursion(n);
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

    public void towerOfHanoiUsingStack(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> ex) {
        if (n == 0) return;
        if (n > 0) {
            //Shifing the Disk n-1 form to extra pole
            towerOfHanoiUsingStack(n - 1, from, ex, to);
            //Adding the Disk in the target the pole
            to.push(from.pop());
            // Again moving the Disks from extra to target pole
            towerOfHanoiUsingStack(n - 1, ex, to, from);
        }

    }


    public void towerOfHanoiWithOutRescursion(int n) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> src = new Stack<>();
        Stack<Integer> dest = new Stack<>();
        Stack<Integer> aux = new Stack<>();

        // First enter all the values in the stack
        for (int i = n; i >= 1; i--) {
            src.push(i);
        }

        char s = 'S', d = 'D', e = 'A';
        if (n % 2 == 0) {
            d = 'A';
            e = 'D';
        }
        int no_of_steps = (int) Math.pow(2, n) - 1;
        for (int i = 1; i <= no_of_steps; i++) {
            //i%3==1 S-->D
            if (i % 3 == 1) moveDisk(src, dest, s, d, sb);
            //i%3==2 S-->E
            else if (i % 3 == 2) moveDisk(src, aux, s, e, sb);
            //i%3==0 E-->D
           else if (i % 3 == 0) moveDisk(aux, dest, e, d, sb);
        }
        System.out.println(sb.toString());
    }

    public void moveDisk(Stack<Integer> src, Stack<Integer> des, char s, char d, StringBuilder sb) {
        if (src.isEmpty()) {
            src.push(des.peek());
            moveDisk(d, s, des.peek(), sb);
            des.pop();
        } else if (des.isEmpty()) {
            des.push(src.peek());
            moveDisk(s, d, src.peek(), sb);
            src.pop();
        } else if (src.peek() > des.peek()) {
            src.push(des.peek());
            moveDisk(d, s, des.peek(), sb);
            des.pop();
        } else {
            des.push(src.peek());
            moveDisk(s, d, src.peek(), sb);
            src.pop();
        }

    }

    void moveDisk(char fromPeg, char toPeg, int disk, StringBuilder sb) {
        sb.append("Move the disk " + disk +
                " from " + fromPeg + " to " + toPeg);
        sb.append("\n");
    }
}

