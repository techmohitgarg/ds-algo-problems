package com.mohit.greeksofgreeks.stacks;

public class KStacksInSingleArray {
    public static void main(String[] args) {
        // Let us create 3 stacks in an array of size 10
        int k = 5, n = 20;

        KStack ks = new KStack(k, n);
        // Let us put some items in stack number 0
        ks.push(11, 2);
        ks.push(12, 2);
        ks.push(13, 2);
        System.out.println("Popped element from stack 1 is " + ks.pop(2));
        ks.push(14, 2);
        System.out.println("Popped element from stack 1 is " + ks.peek(2));
        ks.push(15, 2);
        System.out.println("Popped element from stack 1 is " + ks.pop(2));
        ks.push(16, 2);
        ks.push(17, 2);
    }


    public static class KStack {
        int kLen = -1;
        int[] kSTopValue;
        int[] stack;
        int size = 0;

        public KStack(int k, int n) {
            this.kLen = k;
            this.size = n;
            kSTopValue = new int[this.kLen];
            stack = new int[this.size];
        }

        public void push(int val, int sn) {
            if (isFull(sn)) {
                System.out.println("Stack " + sn + " is full Value = " + val + " is not able to store");
                return;
            }
            int startIndex = ((sn * size) / kLen);
            int index = (kSTopValue[sn] + startIndex);
            stack[index] = val;
            kSTopValue[sn]++;
        }

        public int pop(int sn) {
            if (isEmpty(sn)) {
                System.out.println("Stack " + sn + " is Empty");
                return -1;
            }
            int startIndex = ((sn * size) / kLen);
            int index = (kSTopValue[sn] + startIndex) - 1;
            int val = stack[index];
            kSTopValue[sn]--;
            return val;
        }

        public int peek(int sn) {
            if (isEmpty(sn)) {
                System.out.println("Stack Empty");
                return -1;
            }
            int startIndex = ((sn * size) / kLen);
            int index = (kSTopValue[sn] + startIndex) - 1;
            int val = stack[index];
            return val;
        }


        public int size(int sn) {
            return kSTopValue[sn] + 1;
        }

        public boolean isEmpty(int sn) {
            return ((kSTopValue[sn]) <= 0);
        }

        public boolean isFull(int sn) {
            int len = getSize(sn);
            if ((kSTopValue[sn]) >= len) {
                return true;
            }
            return false;
        }

        private int getSize(int sn) {
            return ((size % kLen) == 0) ? (size / kLen) :
                    (sn == kLen - 1) ? (size / kLen) + 1 : (size / kLen);
        }
    }


}
