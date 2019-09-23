package com.mohit.greeksofgreeks.stacks;

import java.util.Arrays;

public class ArrayWithThreeStacks {

    int size;
    int topOne, topTwo, topThree, baseThree;
    Integer[] array;

    public static void main(String[] args) {
        ArrayWithThreeStacks array = new ArrayWithThreeStacks(10);
    }

    public ArrayWithThreeStacks(int size) {
        this.size = size;
        array = new Integer[size];
        Arrays.fill(array, null);
        topOne = -1;
        topTwo = size;
        baseThree = size / 2;
        topThree = baseThree;
    }

    public void push(int stackId, int val) {
        switch (stackId) {
            case 1:
                if (topOne + 1 == baseThree) {
                    // check if third stack can shift right
                    if (topThree + 1 < topTwo) {
                        for (int i = topThree + 1; i >= baseThree + 1; i--) {
                            array[i] = array[i - 1];
                        }
                        array[baseThree++] = null;
                        topThree++;
                        array[++topOne] = val;
                    } else {
                        new Throwable("Stack One is Full");
                    }

                } else {
                    array[++topOne] = val;
                }
                break;
            case 2:
                if (topTwo - 1 == topThree) {
                    if (topThree - 1 > topOne) {
                        for (int i = baseThree - 1; i <= topThree - 1; i++) {
                            array[i] = array[i + 1];
                        }
                        array[topThree--] = null;
                        baseThree--;
                        array[--topTwo] = val;
                    } else {
                        new Throwable("Stack Two is Full");
                    }
                } else {
                    array[--topTwo] = val;
                }
                break;
            case 3:
                if (topTwo - 1 == topThree) {
                    if (topThree - 1 < topThree) {
                        for (int i = baseThree - 1; i <= topThree - 1; i++) {
                            array[i] = array[i + 1];
                        }
                        array[topThree--] = null;
                        baseThree--;
                        array[++topThree] = val;
                    } else {
                        new Throwable("Stack Three is Full");
                    }
                } else {
                    array[++topThree] = val;
                }
                break;
        }

    }


    public int top(int stackId) {
        switch (stackId) {
            case 1:
                if (topOne < 0) {
                    new Throwable("IndexOutOfBoundExecution");
                }
                return array[topOne];
            case 2:
                if (topTwo >= size) {
                    new Throwable("IndexOutOfBoundExecution");
                }
                return array[topTwo];
            case 3:
                if (topThree == baseThree && array[topThree] == null) {
                    new Throwable("IndexOutOfBoundExecution");
                }
                return array[topThree];

        }
        return -1;
    }


    public int pop(int stackId) {
        switch (stackId) {
            case 1:
                if (topOne < 0) {
                    new Throwable("IndexOutOfBoundExecution");
                }
                int temp = array[topOne];
                array[topOne--] = null;
                return temp;
            case 2:
                if (topTwo >= size) {
                    new Throwable("IndexOutOfBoundExecution");
                }
                temp = array[topTwo];
                array[topTwo++] = null;
                return temp;
            case 3:
                if (topThree == baseThree && array[topThree] == null) {
                    new Throwable("IndexOutOfBoundExecution");
                }
                temp = array[topThree];
                if (topThree > baseThree)
                    array[topThree--] = null;
                if (topThree == baseThree)
                    array[topThree] = null;
                return temp;

        }
        return -1;
    }

    public boolean isEmpty(int stackId) {
        switch (stackId) {
            case 1:
                return topOne <= -1;
            case 2:
                return topTwo >= size;
            case 3:
                return (topThree == baseThree) && array[baseThree] == null;

        }
        return false;
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
