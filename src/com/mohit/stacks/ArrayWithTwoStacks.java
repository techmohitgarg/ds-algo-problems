package com.mohit.stacks;

import java.util.Arrays;

public class ArrayWithTwoStacks {

    int size;
    int left;
    int right;
    Integer[] array;

    public static void main(String[] args) {
        ArrayWithTwoStacks array = new ArrayWithTwoStacks(10);
        array.push(1, 1);
        array.push(2, 2);
        array.push(1, 3);
        array.push(2, 4);
        array.print();
        System.out.println(array.pop(1));
        array.print();
        array.push(2, 5);
        array.print();
        System.out.println(array.pop(2));
        System.out.println(array.pop(2));
        System.out.println(array.pop(2));
        System.out.println(array.pop(1));
        System.out.println(array.pop(1));
        System.out.println(array.pop(1));
        array.print();
    }

    public ArrayWithTwoStacks(int size) {
        this.size = size;
        array = new Integer[size];
        Arrays.fill(array, null);
        left = -1;
        right = size;
    }

    public void push(int stackId, int val) {
        if ((right == left + 1)) {
            new Throwable("Stack is Full");
        } else if (stackId == 1) {
            array[++left] = val;
        } else if (stackId == 2) {
            array[--right] = val;
        }
    }


    public int top(int stackId) {
        if (stackId == 1) {
            if (left <= -1) {
                new Throwable("First Stack is Empty");
            }
            return array[left];
        } else if (stackId == 2) {
            if (right >= size) {
                new Throwable("Second Stack is Empty");
            }
            return array[right];
        }
        return -1;
    }


    public int pop(int stackId) {
        if (stackId == 1) {
            if (left <= -1) {
                new Throwable("First Stack is Empty");
            }
            int temp = array[left];
            array[left] = null;
            left--;
            return temp;

        } else if (stackId == 2) {
            if (right >= size) {
                new Throwable("Second Stack is Empty");
            }
            int temp = array[right];
            array[right] = null;
            right++;
            return temp;
        }
        return -1;
    }

    public boolean isEmpty(int stackId) {
        if (stackId == 1) {
            return left <= -1;
        } else if (stackId == 2) {
            return right >= size;
        } else {
            return false;
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (array != null)
                sb.append(array[i]);
                sb.append(",");
        }
        System.out.println(sb.toString());
    }
}
